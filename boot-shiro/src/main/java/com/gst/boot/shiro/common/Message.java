package com.gst.boot.shiro.common;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    private final static int SUCCESS_CODE = 0;
    private int code;
    private String msg;
    private Object data;


    public Message(int code) {
        this.code = code;
        this.msg = null;
    }

    public Message(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public Message(int code, Object data) {
        this.code = code;
        this.msg = null;
        this.data = data;
    }

    public static Message success() {
        return new Message(SUCCESS_CODE);
    }

    public static Message success(Object data) {
        return new Message(SUCCESS_CODE, data);
    }

    public static Message success(String msg) {
        return new Message(SUCCESS_CODE, msg);
    }

    public static Message failure(int code) {
        return new Message(code);
    }

    public static Message failure(int code, String message) {
        return new Message(code, message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
