package com.example.api.test.pattern.single;
/** 
* 饱汉模式 -线程安全的进化版
* 
* @Author: lfl
* @Date: 2020/1/7 15:39 
*/ 
public class SingleDemo5 {
    private SingleDemo5(){};
    private static SingleDemo5 demo;

    public static SingleDemo5 getInstance(){
        if(demo == null){
            synchronized (SingleDemo5.class){
                if(demo == null){
                    demo = new SingleDemo5();
                }
            }
        }
        return demo;
    }
}
