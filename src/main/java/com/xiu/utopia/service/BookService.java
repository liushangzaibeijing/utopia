package com.xiu.utopia.service;

import com.github.pagehelper.PageInfo;
import com.xiu.utopia.entity.Book;
import com.xiu.utopia.vo.BookVo;

public interface BookService {


    /**
     * 根据查询条件查询对应的书籍列表
     * @param book
     * @return
     */
    PageInfo<BookVo> queryBookListWithPage(Book book, Integer pageNum, Integer pageSize);

    /**
     * 根据主键查询书籍信息
     * @param id 主键
     * @return
     */
    BookVo queryBookbyId(Integer id);
}
