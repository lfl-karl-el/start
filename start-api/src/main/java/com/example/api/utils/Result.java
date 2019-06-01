package com.example.api.utils;

import java.io.Serializable;

public class Result implements Serializable{
    private boolean success;

    private String info;

    private Object obj;

    public Result(boolean success){
        this.success = success;
    }

    public Result(boolean success,String info){
        this.success = success;
        this.info = info;
    }

    public Result(boolean success,String info,Object obj){
        this.success = success;
        this.info = info;
        this.obj = obj;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
