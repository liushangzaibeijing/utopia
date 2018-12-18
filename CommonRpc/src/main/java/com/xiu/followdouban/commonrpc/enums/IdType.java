package com.xiu.followdouban.commonrpc.enums;

public enum IdType {
    SQL(1,"sql"),
    LUCENE(2,"lucene"),
    UNKNOWN(99,"unkown");

    private long code;
    private String name;

    IdType(int code, String name){
        this.code = code;
        this.name = name;
    }

    public static IdType fromCode(long code) {
        for (IdType type : IdType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return IdType.UNKNOWN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }
}
