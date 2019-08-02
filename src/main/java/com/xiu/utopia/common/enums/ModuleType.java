package com.xiu.utopia.common.enums;

public enum  ModuleType {
    MOVIE(1,"电影"),
    BOOK(2,"书籍"),
    UNKNOWN(99,"未知");

    private long code;
    private String name;

    ModuleType(int code, String name){
        this.code = code;
        this.name = name;
    }

    public static ModuleType fromCode(long code) {
        for (ModuleType type : ModuleType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return ModuleType.UNKNOWN;
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
