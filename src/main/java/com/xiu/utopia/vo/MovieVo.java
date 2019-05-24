package com.xiu.utopia.vo;

import com.xiu.utopia.entity.Movie;

public class MovieVo extends Movie{

    /**
     * 电影名字简称
     */
    private String shortName;

    /**
     * 电影简介 指定字符内
     */
    private String shortSynopsis;


    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortSynopsis() {
        return shortSynopsis;
    }

    public void setShortSynopsis(String shortSynopsis) {
        this.shortSynopsis = shortSynopsis;
    }
}
