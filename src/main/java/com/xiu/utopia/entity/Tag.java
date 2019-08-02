package com.xiu.utopia.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-07-25
 */
public class Tag {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 标签名
     */
    private String name;

    /**
     * 标签code
     */
    private String code;

    /**
     * 标签描述
     */
    private String descption;

    /**
     * 父标签
     */
    private Integer parentId;

    /**
     * 标签所属类型

     */
    private Integer type;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getDescption() {
        return descption;
    }

    public void setDescption(String descption) {
        this.descption = descption == null ? null : descption.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}