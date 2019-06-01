package com.example.api.test.Thread.Demo.Demo4;

import java.util.concurrent.TimeUnit;

/**
 * @program: start
 * @description:
 * @author: Mr.lfl
 * @create: 2019-05-27 14:18
 **/
public class InterruptedDemo {
    public static void main(String[] args) {
        BlockInter inter = new BlockInter();
        Thread t = new Thread(inter);
        t.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.interrupt();
    }
}

class BlockInter implements Runnable{
    private volatile double d = 0.0;
    @Override
    public void run(){
        try {

            while(!Thread.interrupted()){
                NeedCleanup n1 = new NeedCleanup(1);
                try {
                    System.out.println("sleep");
                    NeedCleanup n2 = new NeedCleanup(2);
                    try {
                        System.out.println("calculating");
                        for(int i=1;i<2500000;i++){
                            d = d + (Math.PI + Math.E) /d;
                        }
                        System.out.println("fininsh");
                    }finally {
                        n2.cleanup();
                    }
                }finally {
                    n1.cleanup();
                }
            }
            System.out.println("Exit");
        }finally{

        }
    }
}
