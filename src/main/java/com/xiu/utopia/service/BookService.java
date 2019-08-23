package com.xiu.utopia.service;

import com.github.pagehelper.Page;
import com.xiu.utopia.entity.Book;

public interface BookService {


    /**
     * 根据查询条件查询对应的书籍列表
     * @param book
     * @return
     */
    Page<Book> queryBookListWithPage(Book book, Integer pageNum, Integer pageSize);

    /**
     * 根据主键查询书籍信息
     * @param id 主键
     * @return
     */
    Book queryBookbyId(Integer id);
}
