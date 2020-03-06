package com.example.api.test.pattern.single;

import java.util.concurrent.atomic.AtomicReference;

/**
*  cas方式实现单例模式
*
* @Author: lfl
* @Date: 2020/1/7 16:20
*/
public class SingleDemo7 {
    private SingleDemo7(){};
    private static AtomicReference<SingleDemo7> reference = new AtomicReference<>();

    private static SingleDemo7 getInstance(){
        for(;;){
            SingleDemo7 current = reference.get();
            if(current != null){
                return current;
            }
            current = new SingleDemo7();
            if(reference.compareAndSet(null,current)){
                return current;
            }
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<100000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean flag = SingleDemo7.getInstance() == SingleDemo7.getInstance();
                    if(!flag){
                        System.out.println("不相等");
                    }
                }
            }).start();
        }
    }
}
