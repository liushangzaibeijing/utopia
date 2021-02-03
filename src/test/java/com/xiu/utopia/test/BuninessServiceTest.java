package com.xiu.utopia.test;

import com.xiu.utopia.UtopiaApplication;
import com.xiu.utopia.busConvert.TagConvert;
import com.xiu.utopia.dao.BookMapper;
import com.xiu.utopia.entity.Book;
import com.xiu.utopia.entity.BookExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * author  Administrator
 * date   2018/10/24
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UtopiaApplication.class)
@WebAppConfiguration
public class BuninessServiceTest {

    @Autowired
    TagConvert tagConvert;

    @Autowired
    BookMapper bookMapper;

    @Test
    public void test(){
        tagConvert.convertMovieTags();
    }

    @Test
    public void testBook(){
        tagConvert.convertBookTags();
    }

    @Test
    public void testMovie(){
        tagConvert.convertMovie();
    }

    @Test
    public void testConvertBook(){
        tagConvert.convertBook();
    }


    @Test
    public void updateBookBatch() {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(100,100,100, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<Runnable>(10));
        for(int i = 0;i < 100; i++){
            executor.execute(new UpdateTask(bookMapper));
        }
    }



    class UpdateTask implements Runnable{
        private BookMapper bookMapper;


        public UpdateTask(BookMapper bookMapper) {
            this.bookMapper = bookMapper;
        }

        @Override
        public void run() {
            BookExample example = new BookExample();
            example.createCriteria().andIdEqualTo(2439);
            Book book = new Book();
            book.setScore(0.9);
            int i = bookMapper.updateByExampleSelective(book, example);
            log.info("i:{}",i);
        }
    }



}
