package com.xiu.utopia.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.StringUtils;
import com.xiu.utopia.dao.BookMapper;
import com.xiu.utopia.dao.BusMovieMapper;
import com.xiu.utopia.dao.TagMapper;
import com.xiu.utopia.entity.Book;
import com.xiu.utopia.entity.BookExample;
import com.xiu.utopia.service.BookService;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.vo.MovieVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    BookMapper bookMapper;

    @Autowired
    TagMapper tagMapper;


    @Override
    public Page<Book> queryBookListWithPage(Book book, Integer pageNum, Integer pageSize) {
        if(pageNum == null ){
            pageNum = 0;
        }
        if(pageSize==null || pageSize==0){
            pageSize = 20;
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

        Page<Book> bookPage = (Page<Book>) bookMapper.selectByExample(bookExample);

        //对电影名称 电影简介进行截取
        log.info("本次查询出来的电影数量：{}", JsonUtil.obj2str(bookPage));

        return bookPage;
    }

    @Override
    public Book queryBookbyId(Integer id) {
        return null;
    }
}
