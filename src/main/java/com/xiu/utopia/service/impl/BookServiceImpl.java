package com.xiu.utopia.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;
import com.xiu.utopia.common.Constants;
import com.xiu.utopia.dao.BookMapper;
import com.xiu.utopia.dao.TagMapper;
import com.xiu.utopia.entity.Book;
import com.xiu.utopia.entity.BookExample;
import com.xiu.utopia.service.BookService;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.vo.BookVo;
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

        List<Book> bookList = bookMapper.selectByExample(bookExample);

        List<BookVo> bookVos = convertBookList(bookList);
        PageInfo<BookVo> pageInfo = new PageInfo<>(bookVos);
        //对电影名称 电影简介进行截取
        log.info("本次查询出来的电影数量：{}", JsonUtil.obj2str(bookList));

        return pageInfo;
    }

    @Override
    public Book queryBookbyId(Integer id) {
        return null;
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
