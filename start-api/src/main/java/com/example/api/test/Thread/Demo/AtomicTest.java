package com.example.api.test.Thread.Demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: start
 * @description:
 * @author: Mr.lfl
 * @create: 2019-05-21 14:47
 **/
public class AtomicTest implements Runnable{
    private volatile int i = 0;

    /*
    这里synchronized 锁住的是对象，所以这两个方法是互斥的，不能同时执行
    不同的线程也不能同时访问同一个对象上的不同加锁方法
     */
    public synchronized int getNumber(){return i;};

    public synchronized void setNumber(){
        i++;
        i++;
    };

    /*这里使用安全的Atomic原子类*/
    private AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(100);
                setNumber();
            }catch(InterruptedException e){
            }
        }
    }

    public static void main(String[] args) {
        AtomicTest test = new AtomicTest();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(test);
        for(int i=0;i<100;i++){
            service.execute(new Thread(){
                public void run(){
                    while(true){
                        try {
                            Thread.sleep(1000);
                            int num = test.getNumber();
                            if(num%2 != 0){
                                System.out.println(num);
                            }
                        }catch(InterruptedException e){
                        }
                    }
                }
            });
        }

    }
}
