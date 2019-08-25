package com.xiu.utopia.vo;

import com.xiu.utopia.entity.Book;

public class BookQuery extends Book {

    /**
     * 当前页页码
     */
    private Integer pageNum;
    /**
     * 每页包含的数据大小
     */
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
