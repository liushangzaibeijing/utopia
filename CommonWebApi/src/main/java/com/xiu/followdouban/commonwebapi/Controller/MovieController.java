package com.xiu.followdouban.commonwebapi.Controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.xiu.followdouban.commonrpc.model.Book;
import com.xiu.followdouban.commonrpc.service.LuceneService;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Reference(version = "1.0.0")
    private LuceneService luceneService;

    @RequestMapping("/test/{keyword}")
    public Boolean searchBook(@PathVariable("keyword") String keyword){
        if(StringUtils.isBlank(keyword)){
               System.out.println("the keyword is null");
        }

        String fieldName = "score";
        Long start = 8L;
        Long end = 9L;

        boolean success = luceneService.bookIndexInit();
        //List<Book> books = luceneService.bookSearch(keyword,"name",1);

        return success;

    }
}
