package com.example.api.test.Thread.Demo.Demo1;

/**
 * @program: start
 * @description: 消费者的抽象类
 * @author: Mr.lfl
 * @create: 2019-05-20 11:03
 **/
public abstract class IntGenerator {
    /*是否撤销*/
    public static volatile Boolean IS_CANCLE = false;

    /*获取下一个数*/
    public abstract int next();

    /*撤销*/
    public void cancle(){ IS_CANCLE = true; };

    /*获取撤销标志*/
    public boolean isCancle() {
        return IS_CANCLE;
    }
}
