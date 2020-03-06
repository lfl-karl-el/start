package com.example.api.test.pattern.single;
/**
*
*  内部类单例模式
* @Author: lfl
* @Date: 2020/1/7 15:22
*/
public class SingleDemo3 {
    private SingleDemo3(){};

    private static class InnerSingleDemo{
        private static SingleDemo3 demo = new SingleDemo3();
    }

    public static SingleDemo3 getInstance(){
        return InnerSingleDemo.demo;
    }
}
