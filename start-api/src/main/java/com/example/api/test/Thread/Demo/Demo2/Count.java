package com.example.api.test.Thread.Demo.Demo2;

/**
 * @program: start
 * @description: 总的计数器
 * @author: Mr.lfl
 * @create: 2019-05-27 09:34
 **/
public class Count {
    private int count=0;

    public synchronized int incrment(int num){
        count = count+num;
        return count;
    }

    public synchronized int value(){
        return count;
    }
}
