package com.xiu.utopia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by zhangwb on 2018/5/8.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T> {

    private int  code = 20000;

    private boolean state;

    private T data;

    private String message;

    public ResponseDto() {
        }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
