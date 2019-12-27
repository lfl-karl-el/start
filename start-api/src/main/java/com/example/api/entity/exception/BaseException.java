package com.example.api.entity.exception;

import lombok.Data;

@Data
public class BaseException extends RuntimeException{
    public Type type;
    public  String message;

    public enum Type{
        SUCCESS,
        ERROR;
    }

    public BaseException(Type type, String message) {
        this.type = type;
        this.message = message;
    }

    public BaseException(Type type) {
        this.type = type;
    }
}
