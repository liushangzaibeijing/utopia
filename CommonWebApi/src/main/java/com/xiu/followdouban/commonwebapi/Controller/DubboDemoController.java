package com.xiu.followdouban.commonwebapi.Controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.xiu.followdouban.commonrpc.model.Book;
import com.xiu.followdouban.commonrpc.service.DubboDemoService;
import com.xiu.followdouban.commonrpc.service.LuceneService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DubboDemoController {

    @Reference
    private DubboDemoService dubboDemoService;

    @RequestMapping("/dubbo/{keyword}")
    public String  testDubbo(@PathVariable("keyword") String keyword){
        if(StringUtils.isBlank(keyword)){
               System.out.println("the keyword is null");
        }

        String result = dubboDemoService.dubboTest(keyword);

        return result;

    }
}