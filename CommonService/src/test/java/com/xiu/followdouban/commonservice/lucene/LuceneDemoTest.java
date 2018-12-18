package com.xiu.followdouban.commonservice.lucene;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiu.followdouban.commonrpc.model.Book;
import com.xiu.followdouban.commonrpc.model.BookExample;
import com.xiu.followdouban.commonservice.CommonserviceApplication;
import com.xiu.followdouban.commonservice.mapper.BookMapper;
import com.xiu.followdouban.commonservice.service.LuceneService;
import com.xiu.followdouban.commonservice.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.wltea.analyzer.lucene.IKAnalyzer;

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

    @Autowired
    private LuceneService luceneService;

    //创建索引 书籍
    @Test
    public void  bookIndex(){
         boolean flag =  luceneService.bookIndexInit("bookIndex");

         if(flag){
             log.info("更新索引成功");
         }else{
             log.info("更新索引失败");
         }
    }


    //创建索引 书籍
    @Test
    public void  bookSearch(){
        String[] fields = {"name","author"};
        Map<String,Float> boots = new HashMap<>(2);
        boots.put("name",1.0F);
        boots.put("author",1.0F);
        List<Book> books = null;
        try {
            books = luceneService.bookSearch("bookIndex","未来简史",fields,boots,1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        log.info("查询结果 ： {}",JsonUtil.gsonString(books));
    }

    /**
     * 为所有书籍新创建索引 Document中只包含id,name,author
     */
    @Test
    public void StringIndex() {

        IndexWriter writer = null;
        try {
            //文件索引存放路径
            Directory directory = FSDirectory.open(Paths.get("bookIndex"));
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
