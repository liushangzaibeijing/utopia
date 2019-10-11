package com.xiu.utopia.common.enums;



public enum DeleteType {
    NO_DELETE(0,"正常"),
    DELETE(1,"删除");


    private Integer code;
    private String name;

    DeleteType(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public static DeleteType fromCode(Integer code) {
        for (DeleteType type : DeleteType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return null;
    }

    public static DeleteType fromValue(String value) {
        for (DeleteType type : DeleteType.values()) {
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
