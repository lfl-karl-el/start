package com.example.api.test.Thread.Demo.Demo9;

import java.util.concurrent.TimeUnit;

/**
 * @program: start
 * @description: 死锁
 * @author: Mr.lfl
 * @create: 2019-05-30 09:11
 **/
public class DeadLock {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        new Thread(){
            public void run(){
                synchronized (obj1){
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj2){
                        System.out.println("获得obj2的锁");
                    }
                }


            }
        }.start();

        new Thread(){
            public void run(){
                synchronized (obj2){
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj1){
                        System.out.println("获得obj1的锁");
                    }
                }


            }
        }.start();
    }
}
