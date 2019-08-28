package com.xiu.utopia.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;
import com.xiu.utopia.common.Constants;
import com.xiu.utopia.dao.BookMapper;
import com.xiu.utopia.dao.TagMapper;
import com.xiu.utopia.entity.Book;
import com.xiu.utopia.entity.BookExample;
import com.xiu.utopia.entity.Movie;
import com.xiu.utopia.entity.MovieExample;
import com.xiu.utopia.service.BookService;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.vo.BookVo;
import com.xiu.utopia.vo.MovieVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl extends BaseService implements BookService {

    private Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    BookMapper bookMapper;

    @Autowired
    TagMapper tagMapper;


    @Override
    public  PageInfo<BookVo>  queryBookListWithPage(Book book, Integer pageNum, Integer pageSize) {
        if(pageNum == null ){
            pageNum = 0;
        }
        if(pageSize==null || pageSize==0){
            pageSize = 40;
        }
        PageHelper.startPage(pageNum,pageSize);

        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        if(book.getId()!=null){
            criteria.andIdEqualTo(book.getId());
        }
        if(!StringUtils.isNullOrEmpty(book.getTag())){
            criteria.andTagEqualTo(book.getTag());
        }
        //TODO 其他查询条件 以后根据需求进行添加
        Page<Book> bookList = (Page<Book>)bookMapper.selectByExample(bookExample);

        List<BookVo> bookVos = convertBookList(bookList);
        PageInfo<BookVo> pageInfo = new PageInfo<>(bookVos);
        pageInfo.setTotal(bookList.getTotal());
        pageInfo.setPages(bookList.getPages());
        pageInfo.setPageNum(bookList.getPageNum());
        //对电影名称 电影简介进行截取
        log.info("本次查询出来的电影数量：{}", JsonUtil.obj2str(bookList));

        return pageInfo;
    }

    @Override
    public BookVo queryBookbyId(Integer id) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andIdEqualTo(id);
        List<Book> books =  bookMapper.selectByExample(bookExample);

        if(books==null && books.size()==0){
            return null;
        }
        BookVo bookVo = convertBook(books.get(0));


        return bookVo;
    }

    private List<BookVo> convertBookList(List<Book> bookList) {
        List<BookVo> bookVos = new ArrayList<>();
        for(Book book: bookList){
            BookVo bookVo = convertBook(book);
            bookVos.add(bookVo);
        }
        //设置书籍标签类型
        return  bookVos;
    }

    private BookVo convertBook(Book book) {
        BookVo bookVo = new BookVo();
        BeanUtils.copyProperties(book,bookVo);
        //设置名字简称
        //循环list，把user对象转换成userVO对象
        String shortName = book.getName();

        bookVo.setTagName(convertType(Integer.parseInt(book.getTag())));
        if(shortName.length()>= Constants.MAX_SHORT_NAME){
            bookVo.setShortName(shortName.substring(0,Constants.MAX_SHORT_NAME)+"...");
        }else{
            bookVo.setShortName(shortName);
        }
        return bookVo;
   }

}
