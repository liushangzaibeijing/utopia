package com.xiu.followdouban.commonrpc.model;

public class Movie {
    /**
     * 电影主键
     */
    private Integer id;

    /**
     * 电影名 200
     */
    private String name;

    /**
     * 导演
     */
    private String director;

    /**
     * 制片
     */
    private String screenWriter;

    /**
     * 主演
     */
    private String leadActor;


    /**
     * 标签
     */
    private String tag;

    /**
     * 电影
     */
    private String type;

    /**
     * 制片国家/地区
     */
    private String filmmakingArea;

    /**
     * 语言
     */
    private String language;

    /**
     * 上映日期
     */
    private String releaseTime;

    /**
     * 片长
     */
    private String movieLength;

    /**
     * 别名
     */
    private String alias;

      /**
     * 得分
     */
    private Float score;

    /**
     * 得分
     */
    private String link;

    /**
     * 评论人数
     */
    private Integer evaluateNumber;

    /**
     * 电影图片链接
     */
    private String picture;

    /**
     * 集数 （电视剧相关的标签）
     */
    private Integer setNumber;

    /**
     * 季数（综艺节目）
     */
    private Integer quaternaryNumber;

    /**
     * 内容描述（很多）
     */
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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