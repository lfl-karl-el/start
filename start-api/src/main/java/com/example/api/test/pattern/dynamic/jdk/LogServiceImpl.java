package com.example.api.test.pattern.dynamic.jdk;

public class LogServiceImpl implements LogService{
    @Override
    public void log() {
        System.out.println("打印日志");
    }
}
