package com.xiu.followdouban.commonrpc.model;

import java.io.Serializable;

public class Book extends BaseModel implements Serializable{
    /**
     * 主键
     */
    private Integer id;

    /**
     * 书名
     */
    private String name;
    /**
     * 作者
     */
    private String author;
    /**
     * 译者
     */
    private String translator;
    /**
     * 出版社
     */
    private String publisHouse;
    /**
     * 出版时间
     */
    private String publicationDate;
    /**
     * 价格
     */
    private String price;
    /**
     * 评分
     */
    private Double score;
    /**
     * 评价人数
     */
    private Integer evaluateNumber;
    /**
     * 图片link
     */
    private String picture;
    /**
     * 书籍描述
     */
    private String descption;
    /**
     * 所属分类
     */
    private String tag;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator == null ? null : translator.trim();
    }

    public String getPublisHouse() {
        return publisHouse;
    }

    public void setPublisHouse(String publisHouse) {
        this.publisHouse = publisHouse == null ? null : publisHouse.trim();
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate == null ? null : publicationDate.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
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

    public String getDescption() {
        return descption;
    }

    public void setDescption(String descption) {
        this.descption = descption == null ? null : descption.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }
}