package com.example.api.test.Thread.Demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: start
 * @description:
 * @author: Mr.lfl
 * @create: 2019-05-21 14:11
 **/
public class AttemptLock {
    private Lock lock = new ReentrantLock();

    public void untimed(){
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock():"+captured);
        }finally{
            if(captured){
                lock.unlock();
            }
        }
    }

    public void timed(){
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        try{
            System.out.println("tryLock(2,TimeUnit.SECONDS)"+captured);
        }finally{
            if(captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLock al = new AttemptLock();
        al.untimed();
        al.timed();

        new Thread(){
            {setDaemon(true);}
            public void run(){
                al.lock.lock();
                System.out.println("acquire");
            }
        }.start();
        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
        }

        al.untimed();
        al.timed();
    }

}
