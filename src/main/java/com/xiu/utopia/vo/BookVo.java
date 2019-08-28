package com.xiu.utopia.vo;

import com.xiu.utopia.entity.Book;

public class BookVo extends Book {

    /**
     * 书籍名字简称
     */
    private String shortName;

    /**
     * 书籍类型
     */
    private String tagName;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
