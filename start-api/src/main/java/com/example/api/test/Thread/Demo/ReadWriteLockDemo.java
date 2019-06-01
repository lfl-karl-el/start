package com.example.api.test.Thread.Demo;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: start
 * @description:
 * @author: Mr.lfl
 * @create: 2019-05-29 11:17
 **/
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.writeLock().lock();
                System.out.println("写");
                lock.writeLock().unlock();
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.readLock().lock();
                System.out.println("读");
            }
        });
        t2.start();
    }
}
