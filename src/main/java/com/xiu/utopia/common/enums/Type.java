package com.xiu.utopia.common.enums;


import io.swagger.models.auth.In;

/**
 * 标签的类型分类
 */
public enum Type {


    MOVCIE_TYPE(1,"电影"),
    BOOK_TYPE(2,"书籍");


    private Integer code;
    private String name;

    Type(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public static Type fromCode(Integer code) {
        for (Type type : Type.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public static Type fromValue(String value) {
        for (Type type : Type.values()) {
            if (type.getName().equals(value)) {
                return type;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
