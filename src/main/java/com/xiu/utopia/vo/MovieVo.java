package com.xiu.utopia.vo;

import com.xiu.utopia.entity.Actor;
import com.xiu.utopia.entity.Director;
import com.xiu.utopia.entity.Movie;

import java.util.List;

public class MovieVo extends Movie {

    /**
     * 电影名字简称
     */
    private String shortName;

    /**
     * 电影简介 指定字符内
     */
    private String shortSynopsis;

    /**
     * 电影所属标签字符串
     */
    private String TypeName;

    /**
     * 导演
     */
    private List<Director> directors;


    /**
     * 主要演员
     */
    private List<Actor> leadActors;


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


    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }

    public List<Actor> getLeadActors() {
        return leadActors;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public void setLeadActors(List<Actor> leadActors) {
        this.leadActors = leadActors;
    }
}
