package com.xiu.utopia.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xiu.utopia.common.Constants;
import com.xiu.utopia.common.converter.DaoQueryResultVO;
import com.xiu.utopia.entity.Book;
import com.xiu.utopia.service.BookService;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.vo.BookQuery;
import com.xiu.utopia.vo.BookVo;
import com.xiu.utopia.vo.MovieVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwb on 2018/5/14.
 */
@RestController
@RequestMapping("/book")
public class BookController extends BaseController {

    @Autowired
    BookService bookService;



    @RequestMapping("/bookListPage")
    public String getBookPage(@RequestBody BookQuery bookQuery){

        Integer pageNum = (Integer) bookQuery.getPageNum();
        Integer pageSize = (Integer) bookQuery.getPageSize();
        logger.info("当前查询的当前页码：{}",pageNum);

        Book book = new Book();
        BeanUtils.copyProperties(bookQuery,book);
        PageInfo<BookVo> pageInfo =bookService.queryBookListWithPage(book,pageNum,pageSize);

        logger.info("查询出来的书籍信息为：{}",JsonUtil.obj2str(pageInfo.getList()));
        return success(pageTotal(pageInfo));
    }



    @RequestMapping("/bookDetail")
    public String getBookDetail(@RequestBody  Integer id){
       logger.info("查询书籍详情开始");
        Book book =bookService.queryBookbyId(id);

        logger.info("查询出来的id 为{}书籍信息为：{}",id,JsonUtil.obj2str(book));
        return success(JsonUtil.obj2str(book));
    }
}
