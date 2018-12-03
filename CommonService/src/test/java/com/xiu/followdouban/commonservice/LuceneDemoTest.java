package com.xiu.followdouban.commonservice;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiu.followdouban.commonrpc.model.Book;
import com.xiu.followdouban.commonrpc.model.BookExample;
import com.xiu.followdouban.commonservice.mapper.BookMapper;
import com.xiu.followdouban.commonservice.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author   xieqx
 * createTime  2018/12/2
 * desc lucene
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonserviceApplication.class)
@WebAppConfiguration
public class LuceneDemoTest {
    private final Integer pageSize = 20;

    private String indexDir = "bookIndex";

    @Autowired
    private BookMapper bookMapper;

    //为图书创建索引
    //搜索关键字  书名 作者

    /**
     * 为所有书籍新创建索引 Document中只包含id,name,author
     */
    @Test
    public void bookIndex() {
        Long total = getTotal();
        //log.info("书籍中的总记录数：{}",total);
        Integer pageNum = total % pageSize == 0 ? (int) (total / pageSize) : (int) (total / pageSize + 1);

        IndexWriter writer = null;
        try {
            //文件索引存放路径
            Directory directory = FSDirectory.open(Paths.get(indexDir));
            //分词器
            IKAnalyzer analyzer = new IKAnalyzer();
            //StandardAnalyzer analyzer = new StandardAnalyzer();
            IndexWriterConfig config = new IndexWriterConfig(analyzer);
            writer = new IndexWriter(directory, config);

            //在第一次创建索引的时候
           //writer.commit();
            for (int i = 0; i < pageNum; i++) {
                PageHelper.startPage(i, pageSize);
                List<Book> books = bookMapper.selectByExample(new BookExample());

                List<Document> documents = book2Doc(books);

                writer.addDocuments(documents);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.commit();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


        /**
         * 通过name（姓名），author(作者) 全局搜索
         */
        @Test
        public void bookSearcher(){
            String  key = "东野圭吴";

            Directory directory = null;
            //String indexDir = "bookIndex";
            //加权 不同字段不同的权重，查询的侧重点会有差别
            Map<String, Float> boosts = new HashMap<>();
            boosts.put("name",2.0f);
            boosts.put("author",1.0f);
            //创建查询对象 多域查询对象创建
            //多个字段  name 字段查询，author 作者
            String[] fields = {"name","author"};
            //分词器
            IKAnalyzer analyzer = new IKAnalyzer();
            //StandardAnalyzer analyzer = new StandardAnalyzer();

            List<Book> books = searcher(key, indexDir, boosts, fields, analyzer,1);


            log.info("根据关键字{}查询的结果{}",key, JsonUtil.gsonString(books));
        }

    /**
     * 书籍的关键字搜索
     * @param key 关键字
     * @param indexDir  索引文件的存放路径
     * @param boosts  权重
     * @param fields  查询的字段
     * @param analyzer 分词器
     * @param pageNum 页码
     */
    private List<Book> searcher(String key, String indexDir, Map<String, Float> boosts,
                                String[] fields, Analyzer analyzer, Integer pageNum) {
        List<Book> books = null;

        Directory directory;
        try {
            directory = FSDirectory.open(Paths.get(indexDir));
            IndexReader reader = DirectoryReader.open(directory);


            //TODO 是否需要使用多域名查询
            //MultiFieldQueryParser multiFieldQueryParser = new MultiFieldQueryParser(fields,ikAnalyzer,boosts);
            //Query query = multiFieldQueryParser.parse(key);

             QueryParser queryParser = new QueryParser("name",analyzer);
             Query query = queryParser.parse("东");
             IndexSearcher searcher = new IndexSearcher(reader);
             TopDocs topDocs = searcher.search(query,pageSize*60);

             log.info("查询命中总数：{}",topDocs.totalHits);

             int start = (pageNum-1)*pageSize;
             int end = pageNum*pageSize;

            books = new ArrayList<>();
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            for(int i = start;i<end;i++){
                Document document = searcher.doc(scoreDocs[i].doc);
                Book book = finfBookById(Integer.parseInt(document.get("id")));
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  books;
    }

    /**
     * 获取书籍总记录数
     * @return
     */
    private Book finfBookById(Integer id) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andIdEqualTo(id);
        List<Book> books = bookMapper.selectByExample(bookExample);
        if(books!=null&&books.size()>0){
            return books.get(0);
        }
        return null;
    }


    /**
     * Book 转换为Document
     * @param books
     * @return
     */
    private List<Document> book2Doc(List<Book> books) {
        List<Document> documents = new ArrayList<>();
        for(Book book : books){
            Document document = new Document();
            // id,name.author
            Document doc = new Document();
            Field idField = new TextField("id",book.getId()+"", Field.Store.YES);
            Field nameField = new TextField("name",book.getName(), Field.Store.YES);
            Field authorField = new TextField("author",book.getAuthor(), Field.Store.YES);

            document.add(idField);
            document.add(nameField);
            document.add(authorField);

            documents.add(document);
        }
        return  documents;

    }

    /**
     * 获取书籍总记录数
     * @return
     */
    private Long getTotal() {
        PageHelper.startPage(1,1);
        List<Book> books = bookMapper.selectByExample(new BookExample());
        Page<Book> bookPage = (Page<Book>)books;
        return bookPage.getTotal();
    }


    /**
     * 为所有书籍新创建索引 Document中只包含id,name,author
     */
    @Test
    public void StringIndex() {

        IndexWriter writer = null;
        try {
            //文件索引存放路径
            Directory directory = FSDirectory.open(Paths.get(indexDir));
            //分词器

            IKAnalyzer analyzer = new IKAnalyzer();
            //StandardAnalyzer analyzer = new StandardAnalyzer();
            IndexWriterConfig config = new IndexWriterConfig(analyzer);
            writer = new IndexWriter(directory, config);

            //在第一次创建索引的时候
            Document document = new Document();
            document.add(new StringField("id","i am  student", Field.Store.YES));
            writer.addDocument(document);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.commit();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
