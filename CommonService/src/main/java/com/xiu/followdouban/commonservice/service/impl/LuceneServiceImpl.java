package com.xiu.followdouban.commonservice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiu.followdouban.commonrpc.dto.DescField;
import com.xiu.followdouban.commonrpc.dto.MatchId;
import com.xiu.followdouban.commonrpc.enums.IdType;
import com.xiu.followdouban.commonrpc.enums.ModuleType;
import com.xiu.followdouban.commonrpc.model.Book;
import com.xiu.followdouban.commonrpc.model.BookExample;
import com.xiu.followdouban.commonrpc.model.Movie;
import com.xiu.followdouban.commonrpc.model.MovieExample;
import com.xiu.followdouban.commonservice.mapper.BookMapper;
import com.xiu.followdouban.commonservice.mapper.MovieMapper;
import com.xiu.followdouban.commonservice.service.LuceneService;
import com.xiu.followdouban.commonservice.utils.JsonUtil;
import com.xiu.followdouban.commonservice.utils.LuceneUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.DoublePoint;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.search.spans.SpanQuery;
import org.apache.lucene.search.spans.SpanTermQuery;
import org.apache.lucene.search.spans.Spans;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class LuceneServiceImpl implements LuceneService {
    private final Integer pageSize = 20;

    /**
     * 书籍索引存放路径
     */
    private String bookIndexDir = "bookIndex";

    /**
     * 电影索引存放路径
     */
    private String movieIndexDir = "movieIndex";

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
    public boolean bookIndexInit() {
       return bookIndexInit(bookIndexDir);
    }

    /**
     * 为书籍创建索引初始化操作
     * @return
     */
    @Override
    public boolean bookIndexInit(String indexDir) {
        List<DescField> descFields = new ArrayList<>();
        DescField idField = new DescField("id");
        DescField nameField = new DescField("name");
        DescField authorField = new DescField("author");
        //整体查询
        DescField tagField = new DescField("tag",true,false);
        DescField scoreField = new DescField("score",true,false);
        descFields.add(idField);
        descFields.add(nameField);
        descFields.add(authorField);
        descFields.add(tagField);
        descFields.add(scoreField);

        return indexInit(ModuleType.BOOK,descFields,indexDir);
    }

    /**
     * 书籍关键子搜索
     * @param keyword 关键字
     * @param fields 需要查询的字段
     * @param boosts 不同字段的
     * @param pageNum 当前页码
     * @return 搜索出来的书籍信息
     */
    @Override
    public List<Book> bookSearch(String indexDir,String keyword,String[] fields,Map<String,Float> boosts,Integer pageNum) throws ParseException {
        List<Book> books = new ArrayList<>();

        //TODO 是否需要使用多域名查询
        MultiFieldQueryParser multiFieldQueryParser = new MultiFieldQueryParser(fields,analyzer,boosts);
        Query query = multiFieldQueryParser.parse(keyword);

        List<Document> documents = getDocumentList(indexDir,analyzer,query,pageNum);
        for(Document document:documents){
            Book book = findBookById(Integer.parseInt(document.get("id")));
            books.add(book);
        }
        return  books;
    }

    @Override
    public List<Book> bookSearch(String keyword, String field, Integer pageNum) {
        return bookSearch(bookIndexDir,keyword,field,pageNum);
    }


    /**
     * 根据TermQuery进行查询
     * @param indexDir 索引文件
     * @param keyword 关键字
     * @param field 字段
     * @param pageNum 当前页码
     * @return 搜索出来的书籍信息
     */
    @Override
    public List<Book> bookSearch(String indexDir, String keyword, String field, Integer pageNum) {
        List<Book> books = new ArrayList<>();
        Query termQuery = new TermQuery(new Term(field,keyword));
        List<Document> documents = getDocumentList(indexDir,analyzer,termQuery, pageNum);
        for(Document document:documents){
            Book book = findBookById(Integer.parseInt(document.get("id")));
            books.add(book);
        }
        return  books;
    }

    @Override
    public List<Book> bookSearch(String field, String start,String end,Boolean includeStart,Boolean includeEnd,Integer pageNum){
       return  bookSearch (bookIndexDir,field,start,end,includeStart,includeEnd,analyzer,pageNum);
    }

    /**
     * 根据数值类型的范围查询
     * @param field 字段名称
     * @param start 开始范围 数值类型
     * @param end 结束范围   数值类型
     * @param pageNum 页码
     * @return
     */
    @Override
    public List<Book> bookSearch(String field, Long start, Long end, Integer pageNum) {
        List<Book> books = new ArrayList<>();

        Query numericQuery = DoublePoint.newRangeQuery(field,start,end);
        //Query numericQuery = NumericDocValuesField.newSlowRangeQuery("score",start,end);
        List<Document> documents = getDocumentList(bookIndexDir,analyzer,numericQuery, pageNum);
        for(Document document:documents){
            Book book = findBookById(Integer.parseInt(document.get("id")));
            books.add(book);
        }
        return null;
    }

    /**
     * @param query
     * @param pageNum
     * @return
     */
    @Override
    public List<Book> bookSearch(Query query, Integer pageNum) {
        List<Book> books = new ArrayList<>();
        List<Document> documents = getDocumentList(bookIndexDir,analyzer,query, pageNum);
        for(Document document:documents){
            Book book = findBookById(Integer.parseInt(document.get("id")));
            books.add(book);
        }
        return books;
    }

    /**
     *
     * @param indexDir 索引文件
     * @param field 字段名称
     * @param start 开始范围
     * @param end 结束范围
     * @param analyzer 分词器
     * @param pageNum 页码
     * @return
     */
    private List<Book> bookSearch(String indexDir, String field, String start,String end, Boolean includeStart,Boolean includeEnd,Analyzer analyzer, Integer pageNum) {
        List<Book> books = new ArrayList<>();

        BytesRef lowerTerm = new BytesRef(start.getBytes()) ;
        BytesRef upperTerm = new BytesRef(end.getBytes()) ;

        Query termRangeQuery = new TermRangeQuery("name",lowerTerm,upperTerm,includeStart,includeEnd);

        List<Document> documents = getDocumentList(indexDir,analyzer,termRangeQuery, pageNum);
        for(Document document:documents){
            Book book = findBookById(Integer.parseInt(document.get("id")));
            books.add(book);
        }
        return  books;
    }


    /**
     * 为电影创建索引初始化操作
     * @return 初始化成功与否的标识
     */
    @Override
    public boolean movieIndexInit() {
        return movieIndexInit(movieIndexDir);
    }

    /**
     * 为电影创建索引初始化操作
     * @return 初始化成功与否的标识
     */
    @Override
    public boolean movieIndexInit(String indexDir) {
        List<DescField> descFields = new ArrayList<>();
        DescField idField = new DescField("id");
        DescField nameField = new DescField("name");
        DescField directorField = new DescField("director");
        DescField screenWriterField = new DescField("screenWriter");
        DescField leadActorField = new DescField("leadActor");
        //整体查询
        DescField typeField = new DescField("type",true,false);
        DescField scoreField = new DescField("score",true,false);
        descFields.add(idField);
        descFields.add(nameField);
        descFields.add(directorField);
        descFields.add(screenWriterField);
        descFields.add(leadActorField);
        descFields.add(typeField);
        descFields.add(scoreField);

        return indexInit(ModuleType.MOVIE,descFields,indexDir);
    }

    /**
     * 电影关键字搜索
     * @param keyword 关键字
     * @param fields 需要查询的字段
     * @param boosts 不同字段的
     * @param pageNum 当前页码
     * @return 根据搜索条件查询到的电影信息
     */
    @Override
    public List<Movie> movieSearch(String indexDir,String keyword,String[] fields,Map<String,Float> boosts,Integer pageNum) throws ParseException {
        List<Movie> movies = new ArrayList<>();

        //TODO 是否需要使用多域名查询
        MultiFieldQueryParser multiFieldQueryParser = new MultiFieldQueryParser(fields,analyzer,boosts);
        Query query = multiFieldQueryParser.parse(keyword);

        List<Document> documents = getDocumentList(indexDir,analyzer, query, pageNum);
        for(Document document:documents){
            Movie movie = findMovieById(Integer.parseInt(document.get("id")));
            movies.add(movie);
        }
        return  movies;
    }

    @Override
    public boolean clearIndex(String indexDir) {
        IndexWriter writer = null;
        try {
            //文件索引存放路径
            Directory directory = FSDirectory.open(Paths.get(bookIndexDir));
            IndexWriterConfig config = new IndexWriterConfig(analyzer);
            writer = new IndexWriter(directory, config);
            writer.deleteAll();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.commit();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<MatchId> matchDiff(List<Book> books, BookExample bookExample) {
        List<Book> sqlBooks = bookMapper.selectByExample(bookExample);

        List<Integer> lucendIds = new ArrayList<>();

        books.stream().forEach(book ->{
            lucendIds.add(book.getId());
        });
        List<Integer> sqlIds = new ArrayList<>();
        sqlBooks.stream().forEach(book ->{
            sqlIds.add(book.getId());
        });

        List<MatchId> matchIds = compareMatch(lucendIds,sqlIds);
        return matchIds;
    }

    @Override
    public List<MatchId> matchDiff(List<Movie> movies, MovieExample movieExample) {
        List<Movie> sqlMovies = movieMapper.selectByExample(movieExample);

        List<Integer> lucendIds = new ArrayList<>();

        movies.stream().forEach(book ->{
            lucendIds.add(book.getId());
        });
        List<Integer> sqlIds = new ArrayList<>();
        sqlMovies.stream().forEach(book ->{
            sqlIds.add(book.getId());
        });

        List<MatchId> matchIds = compareMatch(lucendIds,sqlIds);
        return matchIds;
    }

    @Override
    public Float matchRatio(List<Book> books, BookExample bookExample) {
        List<Book> sqlBooks = bookMapper.selectByExample(bookExample);

        List<Integer> lucendIds = new ArrayList<>();

        books.stream().forEach(book ->{
            lucendIds.add(book.getId());
        });
        List<Integer> sqlIds = new ArrayList<>();
        sqlBooks.stream().forEach(book ->{
            sqlIds.add(book.getId());
        });

        Float ratio = compareMatchRatio(lucendIds,sqlIds);
        return ratio;
    }

    @Override
    public Float matchRatio(List<Movie> movies, MovieExample movieExample) {
        List<Movie> sqlMovies = movieMapper.selectByExample(movieExample);

        List<Integer> lucendIds = new ArrayList<>();

        movies.stream().forEach(book ->{
            lucendIds.add(book.getId());
        });
        List<Integer> sqlIds = new ArrayList<>();
        sqlMovies.stream().forEach(book ->{
            sqlIds.add(book.getId());
        });

       Float ratio = compareMatchRatio(lucendIds,sqlIds);
        return ratio;
    }


    /**
     * 针对lucene索引和sql索引两种结构进行查看其不同之处
     * 以检测lucene功能的检索正确率
     * @param luceneIds 使用lucene 查询出来的索引
     * @param sqlIds 使用sql查询出来的索引
     * @return 其中的差集数据
     */
    private List<MatchId> compareMatch(List<Integer> luceneIds,List<Integer> sqlIds){
        List<MatchId> luceneMatchIds = new ArrayList<>();
        for(Integer luceneid:luceneIds){
            MatchId matchId = new MatchId(luceneid, IdType.LUCENE);
            luceneMatchIds.add(matchId);
        }

        //log.info("lucene中查询出来的索引信息：{}", JsonUtil.gsonString(luceneMatchIds));

        List<MatchId> sqlMatchIds = new ArrayList<>();
        for(Integer sqlid:sqlIds){
            MatchId matchId = new MatchId(sqlid, IdType.SQL);
            sqlMatchIds.add(matchId);
        }

        //log.info("sql中查询出来的索引信：{}",JsonUtil.gsonString(sqlMatchIds));
        List<MatchId> temp = new ArrayList<>(luceneMatchIds);
        //获取两个集合之间的差集 其实是属于A 但不属于B的值
        luceneMatchIds.removeAll(sqlMatchIds);
        sqlMatchIds.removeAll(temp);
        luceneMatchIds.addAll(sqlMatchIds);

        log.info("两个集合之间的差集：{}",JsonUtil.gsonString(luceneMatchIds));
        log.info("差集大小：{}",luceneMatchIds.size());
        return  luceneMatchIds;
    }

    /**
     * 针对lucene索引和sql索引两种结构进行查看其不同之处
     * 以检测lucene功能的检索正确率
     * @param luceneIds 使用lucene 查询出来的索引
     * @param sqlIds 使用sql查询出来的索引
     * @return 匹配成功的百分比
     */
    private Float compareMatchRatio(List<Integer> luceneIds,List<Integer> sqlIds){
        if(luceneIds.size()==0 || sqlIds.size() == 0){
            return 0F;
        }
        List<MatchId> luceneMatchIds = new ArrayList<>();
        for(Integer luceneid:luceneIds){
            MatchId matchId = new MatchId(luceneid, IdType.LUCENE);
            luceneMatchIds.add(matchId);
        }

        //log.info("lucene中查询出来的索引信息：{}", JsonUtil.gsonString(luceneMatchIds));

        List<MatchId> sqlMatchIds = new ArrayList<>();
        for(Integer sqlid:sqlIds){
            MatchId matchId = new MatchId(sqlid, IdType.SQL);
            sqlMatchIds.add(matchId);
        }

       //获取两者之间的交集
        luceneMatchIds.retainAll(sqlMatchIds);

        return  luceneMatchIds.size()/(float)sqlMatchIds.size();
    }

    /**
     * 信息进行索引操作
     * @param moduleType 模块类型
     * @param descFields 字段类型
     * @param indexDir 索引路径
     * @return
     */
    private boolean indexInit(ModuleType moduleType, List<DescField> descFields,String indexDir) {
        Long total = getTotal(moduleType);
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
            for (int i = 0; i < pageNum; i++) {
                PageHelper.startPage(i, pageSize);

                List typelist = new ArrayList();
                if(moduleType.getCode()==2){
                    typelist = bookMapper.selectByExample(new BookExample());
                }
                if(moduleType.getCode()==1){
                    typelist = movieMapper.selectByExample(new MovieExample());
                }

                List<Document> documents = LuceneUtils.obj2Doc(typelist,descFields);
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
     * 根据不同的分词器，Query对象
     * @param indexDir 索引的存放位置
     * @param analyzer 分词器
     * @param query 查询对象
     * @param pageNum 当前页码
     * @return
     */
    private List<Document> getDocumentList(String indexDir,Analyzer analyzer, Query query, Integer pageNum) {
        List<Document> documents = null;
        try {
            Directory directory = FSDirectory.open(Paths.get(indexDir));
            IndexReader reader = DirectoryReader.open(directory);

            IndexSearcher searcher = new IndexSearcher(reader);
            //获取当前索引
            ScoreDoc currentDoc = getLastDoc(searcher,query,pageNum);
            TopDocs topDocs = searcher.searchAfter(currentDoc,query,pageSize);

            log.info("查询命中总数：{}",topDocs.totalHits);

            documents = new ArrayList<>();
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            int len = scoreDocs.length;
            if(scoreDocs == null && len  == 0){
                return null;
            }
            int end = len<=pageSize?len:pageSize;
            for(int i = 0;i<end;i++){
                Document document = searcher.doc(scoreDocs[i].doc);
                documents.add(document);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return documents;
    }

    /**
     * 获取当前最近的索引信息
     * @param searcher 搜索操作
     * @param query 查询对象
     * @param pageNum 当前页码
     */
    private ScoreDoc getLastDoc(IndexSearcher searcher, Query query, Integer pageNum) {
        try {
            //第一页的话就没必要涉及到
            if(pageNum == 1) return null;
            TopDocs topDocs = searcher.search(query,pageSize*(pageNum-1));
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            return scoreDocs[scoreDocs.length-1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 根据id获取书籍信息
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
     * 根据id获取电影信息
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
