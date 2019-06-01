package com.example.api.test.Thread.Demo.Demo9;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program: start
 * @description:
 * @author: Mr.lfl
 * @create: 2019-05-30 14:00
 **/
public class CASDemo {
    public static void main(String[] args) {
        TwoLock twoLock = new TwoLock();
        new Thread(){
            public void run(){
                twoLock.lock();
                System.out.println(1);
            }
        }.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(){
            public void run(){
                twoLock.lock();
                System.out.println(2);
                twoLock.unlock();
            }
        }.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(){
            public void run(){
                twoLock.lock();
                System.out.println(3);
            }
        }.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(){
            public void run(){
                twoLock.lock();
                System.out.println(4);
            }
        }.start();
    }
}

class TwoLock implements Lock{
    private Sync sync = new Sync(2);

    private static class Sync extends AbstractQueuedSynchronizer{
        private int lockNum;
        public Sync(int num){
            this.lockNum = num -1;
        }
        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0, 1)){
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(compareAndSetState(1, 0)){
                return true;
            }
            return false;
        }

        @Override
        protected int tryAcquireShared(int arg) {
            int current = this.lockNum - getState();
            compareAndSetState(getState(), getState()+1);
            return current;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            compareAndSetState(getState(), getState() -1 );
            if(getState() > 0){
                return true;
            }
            return false;
        }

        @Override
        protected boolean isHeldExclusively() {
            return super.isHeldExclusively();
        }
    }

    @Override
    public void lock() {
//        sync.acquire(1);  独占模式
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
//        return sync.tryAcquire(1);  独占模式
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
//        long now = System.currentTimeMillis();
//        while(System.currentTimeMillis() < now + time){
//            if(sync.tryAcquire(1)){
//                return true;
//            }
//        }    独占模式
        return false;
    }

    @Override
    public void unlock() {
        sync.tryReleaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
