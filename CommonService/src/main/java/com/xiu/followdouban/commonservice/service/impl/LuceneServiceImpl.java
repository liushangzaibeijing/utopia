package com.xiu.followdouban.commonservice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiu.followdouban.commonrpc.enums.ModuleType;
import com.xiu.followdouban.commonrpc.model.Book;
import com.xiu.followdouban.commonrpc.model.BookExample;
import com.xiu.followdouban.commonrpc.model.Movie;
import com.xiu.followdouban.commonrpc.model.MovieExample;
import com.xiu.followdouban.commonservice.mapper.BookMapper;
import com.xiu.followdouban.commonservice.mapper.MovieMapper;
import com.xiu.followdouban.commonservice.service.LuceneService;
import com.xiu.followdouban.commonservice.utils.LuceneUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class LuceneServiceImpl implements LuceneService {
    private final Integer pageSize = 20;

    /**
     * 索引存放路径
     */
    private String indexDir = "bookIndex";

    /**
     * 分词器
     */
    private IKAnalyzer analyzer = new IKAnalyzer();

    /**
     * 书籍mapper
     */
    @Autowired
    private BookMapper bookMapper;

    /**
     * 电影mapper
     */
    @Autowired
    private MovieMapper movieMapper;


    /**
     * 为书籍创建索引初始化操作
     * @return
     */
    @Override
    public boolean bookIndexInit(String indexDir) {
        Map<String,Boolean> fieldMap = new HashMap<>(5);
        fieldMap.put("id",true);
        fieldMap.put("name",true);
        fieldMap.put("author",true);
        return indexInit(ModuleType.BOOK,fieldMap,indexDir);
    }

    /**
     * 书籍关键子搜索
     * @param keyword 关键字
     * @param fields 需要查询的字段
     * @param boosts 不同字段的
     * @param pageNum
     * @return
     */
    @Override
    public List<Book> bookSearch(String indexDir,String keyword,String[] fields,Map<String,Float> boosts,Integer pageNum) {
        List<Book> books = new ArrayList<>();
        List<Document> documents = getDocumentList(indexDir,keyword, fields, boosts, pageNum);
        for(Document document:documents){
            Book book = findBookById(Integer.parseInt(document.get("id")));
            books.add(book);
        }
        return  books;
    }



    /**
     * 为电影创建索引初始化操作
     * @return
     */
    @Override
    public boolean movieIndexInit(String indexDir) {
        Map<String,Boolean> fieldMap = new HashMap<>(5);
        //演员 制片，演员
        fieldMap.put("id",true);
        fieldMap.put("name",true);
        fieldMap.put("director",true);
        fieldMap.put("screenWriter",true);
        fieldMap.put("leadActor",true);

        return indexInit(ModuleType.MOVIE,fieldMap,indexDir);
    }

    private boolean indexInit(ModuleType movie, Map<String,Boolean> fieldMap,String indexDir) {
        Long total = getTotal(movie);
        //log.info("书籍中的总记录数：{}",total);
        Integer pageNum = total % pageSize == 0 ? (int) (total / pageSize) : (int) (total / pageSize + 1);

        IndexWriter writer = null;
        try {
            //文件索引存放路径
            Directory directory = FSDirectory.open(Paths.get(indexDir));
            IndexWriterConfig config = new IndexWriterConfig(analyzer);
            writer = new IndexWriter(directory, config);

            //在第一次创建索引的时候
            //writer.commit();
            for (int i = 0; i < 20; i++) {
                PageHelper.startPage(i, pageSize);

                List typelist = new ArrayList();
                if(movie.getCode()==2){
                    typelist = bookMapper.selectByExample(new BookExample());
                }
                if(movie.getCode()==1){
                    typelist = movieMapper.selectByExample(new MovieExample());
                }

                List<Document> documents = null;
                documents = LuceneUtils.obj2Doc(typelist,fieldMap);
                writer.addDocuments(documents);
            }

        } catch (IOException e) {
            e.printStackTrace();
            log.info("对书籍建立索引失败，错误信息为:{}", e.getMessage());
            return false;
        } finally {
            try {
                writer.commit();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * 书籍关键子搜索
     * @param keyword 关键字
     * @param fields 需要查询的字段
     * @param boosts 不同字段的
     * @param pageNum 当前页码
     * @return
     */
    @Override
    public List<Movie> movieSearch(String indexDir,String keyword,String[] fields,Map<String,Float> boosts,Integer pageNum) {
        List<Movie> movies = new ArrayList<>();
        List<Document> documents = getDocumentList(indexDir,keyword, fields, boosts, pageNum);
        for(Document document:documents){
            Movie movie = findMovieById(Integer.parseInt(document.get("id")));
            movies.add(movie);
        }
        return  movies;
    }

    /**
     * 书籍关键子搜索
     * @param keyword 关键字
     * @param fields 需要查询的字段
     * @param boosts 不同字段的
     * @param pageNum 当前页码
     * @return
     */
    private List<Document> getDocumentList(String indexDir,String keyword, String[] fields, Map<String, Float> boosts, Integer pageNum) {
        List<Document> documents = null;
        try {
            Directory directory = FSDirectory.open(Paths.get(indexDir));
            IndexReader reader = DirectoryReader.open(directory);

            //TODO 是否需要使用多域名查询
            MultiFieldQueryParser multiFieldQueryParser = new MultiFieldQueryParser(fields,analyzer,boosts);
            Query query = multiFieldQueryParser.parse(keyword);

            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs topDocs = searcher.search(query,pageSize*(pageNum+1));

            log.info("查询命中总数：{}",topDocs.totalHits);

            int start = (pageNum-1)*pageSize;
            int end = pageNum*pageSize;

            documents = new ArrayList<>();
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            for(int i = start;i<end;i++){
                Document document = searcher.doc(scoreDocs[i].doc);
                documents.add(document);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return documents;
    }


    /**
     * 获取电影总记录数
     * @return
     */
    private Book findBookById(Integer id) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andIdEqualTo(id);
        List<Book> books = bookMapper.selectByExample(bookExample);
        if(books!=null&&books.size()>0){
            return books.get(0);
        }
        return null;
    }


    /**
     * 获取书籍总记录数
     * @return
     */
    private Movie findMovieById(Integer id) {
        MovieExample movieExample = new MovieExample();
        movieExample.createCriteria().andIdEqualTo(id);
        List<Movie> movies = movieMapper.selectByExample(movieExample);
        if(movies!=null&&movies.size()>0){
            return movies.get(0);
        }
        return null;
    }



    /**
     * 获取书籍总记录数
     * @return
     */
    private Long getTotal(ModuleType moduleType) {
        Page page = new Page();
        PageHelper.startPage(1,1);
        if(moduleType.getCode()==2){
            List<Book> books = bookMapper.selectByExample(new BookExample());
            page = (Page<Book>)books;
        }
        if(moduleType.getCode()==1){
            List<Movie> movies = movieMapper.selectByExample(new MovieExample());
            page = (Page<Movie>)movies;
        }
        return  page.getTotal();

    }


}
