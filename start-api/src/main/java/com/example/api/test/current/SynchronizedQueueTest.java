package com.example.api.test.current;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program: start-SynchronizedQueueTest
 * @description: 练手
 * @author: Mr.lfl
 * @create: 2019-03-19 12:34
 **/
public class SynchronizedQueueTest implements Lock{
    private Sync sync = new Sync();

    private static class Sync extends AbstractQueuedSynchronizer{

//        Sync(int count){
//            System.out.println("队列"+count);
//            if(count <= 0){
//                throw new RuntimeException("线程错误");
//            }
//            setState(count);
//        }

        @Override
        protected boolean tryAcquire(int acquires) {
            if(getState() == 0){
                compareAndSetState(0,1);
                return true;
            }

            return false;
        }

        @Override
        protected boolean tryRelease(int releases) {
            assert releases == 1; // 限定为1个量
            if (getState() == 0)//既然来释放，那肯定就是已占有状态了。只是为了保险，多层判断！
                throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);//释放资源，放弃占有状态
            return true;

        }

        //共享模式 是 返回小于0 就不行，大于0 就可以
        @Override
        protected int tryAcquireShared(int arg) {
            for (;;) {
                int current = getState();
                int newCount = current - arg;
                if (newCount < 0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }


    }

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    //这是那种可以打断的获得锁方式
    @Override
    public void lockInterruptibly() throws InterruptedException {
//        System.out.println("lockInterruptibly");
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquireShared(1) >= 0 ;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
//        System.out.println("tryLock-time");
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    public static void main(String[] args) {
        SynchronizedQueueTest lock = new SynchronizedQueueTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();

                System.out.println(Thread.currentThread()+"1");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();

                System.out.println(Thread.currentThread()+"2");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();

                System.out.println(Thread.currentThread()+"3");
            }
        }).start();

    }
}
