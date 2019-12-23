package com.example.api.test.pattern.dynamic.jdk;
/** 
*
* 
* @Author: lfl
* @Date: 2019/12/20 14:36
*/ 
public class LogTimeServiceImpl implements LogService{
    @Override
    public void log() {
        System.out.println("打印时间："+System.currentTimeMillis());
        System.out.println("打印日志！");
    }

    @Override
    public void exit() {
        System.out.println("日志结束时间："+System.currentTimeMillis());
        System.out.println("日志不打印");
    }
}
