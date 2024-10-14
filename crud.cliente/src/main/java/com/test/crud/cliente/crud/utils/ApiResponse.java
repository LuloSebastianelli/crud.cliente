package com.test.crud.cliente.crud.utils;

public class ApiResponse {

    private String msg;
    private Object data;

    public ApiResponse(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}
