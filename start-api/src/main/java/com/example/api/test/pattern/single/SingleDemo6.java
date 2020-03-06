package com.example.api.test.pattern.single;

/**
* threadLocal方式实现单例模式
*
* @Author: lfl
* @Date: 2020/1/7 15:51
*/
public class SingleDemo6 {
    private SingleDemo6(){};
    private static final ThreadLocal<SingleDemo6> demo = new ThreadLocal<SingleDemo6>(){
        @Override
        protected SingleDemo6 initialValue() {
            return new SingleDemo6();
        }
    };

    private static SingleDemo6 getInstance(){
        return demo.get();
    }
}
