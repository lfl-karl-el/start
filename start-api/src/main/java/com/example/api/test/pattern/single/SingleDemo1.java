package com.example.api.test.pattern.single;
/**
*
*  饿汉模式
* @Author: lfl
* @Date: 2020/1/7 15:17
*/
public class SingleDemo1 {
    private static SingleDemo1 demo = new SingleDemo1();
    private SingleDemo1(){}

    public static SingleDemo1 getInstance(){
        return demo;
    }
}
