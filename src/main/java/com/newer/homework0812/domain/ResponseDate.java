package com.newer.homework0812.domain;

import java.io.Serializable;

public class ResponseDate implements Serializable {
    private static final long serialVersionUID = 1200439867234357432L;
    private String code;
    private String msg;

    public ResponseDate() {
    }

    public ResponseDate(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponseDate{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
