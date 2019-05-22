package com.xiu.utopia.utils;

import java.io.Serializable;

/**
 * Created by jiajun on 2/5/18.
 */
public class ResultUtil<T> implements Serializable {

    public int code;
    private T data = null;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public ResultUtil<T> setData(T data) {
        this.data = data;
        return this;
    }

    public ResultUtil<T> success() {
        ResultUtil result = new ResultUtil<T>();
        result.setCode(20000);
        return result;
    }

    public ResultUtil<T> success(String des) {
        ResultUtil result = new ResultUtil<T>();
        result.setCode(20000);
        result.setData(des);
        return result;
    }

    public ResultUtil<T> failed(String des) {
        ResultUtil result = new ResultUtil<T>();
        result.setCode(50000);
        result.setData(des);
        return result;
    }
}
