package com.yjl.base;

import com.alibaba.fastjson.JSONObject;

/**
 * @program: JavaWeb-Edu
 * @author: yjl
 * @created: 2021/12/04
 */
public enum StatusCode {

    SUCCESS(0, "success"), ERROR(1, "error");

    //定义属性

    private Integer code;

    private String message;

    StatusCode() {
    }

    StatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", code);
        jsonObject.put("msg", message);
        return jsonObject.toString();
    }
}
