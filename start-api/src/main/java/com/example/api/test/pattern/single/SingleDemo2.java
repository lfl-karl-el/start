package com.example.api.test.pattern.single;
/**
*
* 饱汉模式--线程安全的
 * @Author: lfl
* @Date: 2020/1/7 15:17
*/
public class SingleDemo2 {
    private static SingleDemo2 demo ;
    private SingleDemo2(){};

    public static synchronized SingleDemo2 getInstance(){
        if(demo == null){
            demo = new  SingleDemo2();
        }
        return demo;
    }
}
