package com.xiu.utopia.dto;


/**
 * 自定义的数据类型 来描述针对不同字段的是否分词，是否检索，是否存储等操作
 */
public class DescField {
    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 是否存储
     */
    private Boolean store;

    /**
     * 是否分词
     */
    private Boolean analyzer;


    public DescField(String fieldName, Boolean store, Boolean analyzer) {
        this.fieldName = fieldName;
        this.store = store;
        this.analyzer = analyzer;
    }

    public DescField(String fieldName, Boolean store) {
        this.fieldName = fieldName;
        this.store = store;
        this.store = true;
    }

    public DescField(String fieldName) {
        this.fieldName = fieldName;
        this.store = true;
        this.analyzer = true;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Boolean getStore() {
        return store;
    }

    public void setStore(Boolean store) {
        this.store = store;
    }

    public Boolean getAnalyzer() {
        return analyzer;
    }

    public void setAnalyzer(Boolean analyzer) {
        this.analyzer = analyzer;
    }
}
