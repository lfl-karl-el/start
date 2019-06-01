package com.example.api.test.Thread.Demo.Demo7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: start
 * @description:
 * @author: Mr.lfl
 * @create: 2019-05-28 13:55
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args){
        CyclicBarrierTest test = new CyclicBarrierTest();

        for(int i=0;i<2;i++){
            new Thread(){
                @Override
                public void run(){
                    try {
                        System.out.println(Thread.currentThread().getName()+"等待屏障放开");
                        test.cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"开始工作...");
                }
            }.start();
        }
    }
}
class CyclicBarrierTest{
    public CyclicBarrier cyclicBarrier;
    public CyclicBarrierTest(){
        cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("屏障放开后先运行");
                System.out.println("......");
                System.out.println("屏障放开后先运行成功");
            }
        });
    }
}
