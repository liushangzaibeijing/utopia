package com.xiu.utopia.entity;

import com.xiu.utopia.base.BaseModel;

public class Movie extends BaseModel {
    private Integer id;

    private String name;

    private String director;

    private String screenWriter;

    private String leadActor;

    private String tag;

    private Integer type;

    private String filmmakingArea;

    private String language;

    private String releaseTime;

    private String movieLength;

    private String alias;

    private Float score;

    private Integer evaluateNumber;

    private String picture;

    private String link;

    private Integer setNumber;

    private Integer quaternaryNumber;

    private String synopsis;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getScreenWriter() {
        return screenWriter;
    }

    public void setScreenWriter(String screenWriter) {
        this.screenWriter = screenWriter == null ? null : screenWriter.trim();
    }

    public String getLeadActor() {
        return leadActor;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor == null ? null : leadActor.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFilmmakingArea() {
        return filmmakingArea;
    }

    public void setFilmmakingArea(String filmmakingArea) {
        this.filmmakingArea = filmmakingArea == null ? null : filmmakingArea.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime == null ? null : releaseTime.trim();
    }

    public String getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(String movieLength) {
        this.movieLength = movieLength == null ? null : movieLength.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Integer getEvaluateNumber() {
        return evaluateNumber;
    }

    public void setEvaluateNumber(Integer evaluateNumber) {
        this.evaluateNumber = evaluateNumber;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public Integer getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(Integer setNumber) {
        this.setNumber = setNumber;
    }

    public Integer getQuaternaryNumber() {
        return quaternaryNumber;
    }

    public void setQuaternaryNumber(Integer quaternaryNumber) {
        this.quaternaryNumber = quaternaryNumber;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis == null ? null : synopsis.trim();
    }
}