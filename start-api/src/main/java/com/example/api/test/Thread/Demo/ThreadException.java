package com.example.api.test.Thread.Demo;

/**
 * @program: start
 * @description: 线程的异常处理     一般情况下，一个线程的异常不能在另一个线程里面处理，即使try-catch也不能捕获
 * @author: Mr.lfl
 * @create: 2019-05-20 10:02
 **/
public class ThreadException {
    public static void main(String[] args) {
//        ExecutorService service = Executors.newCachedThreadPool();
//        service.execute(new MyThread());

    }
}
//class MyThread extends Thread{
//
//    public MyThread(){
//        Thread.setDefaultUncaughtExceptionHandler(new myException());
//    }
//
//    @Override
//    public void run(){
//        throw new RuntimeException();
//    }
//
//}
//
//class myException implements Thread.UncaughtExceptionHandler{
//
//    @Override
//    public void uncaughtException(Thread t, Throwable e) {
//        System.out.println(e);
//    }
//}

//class ThreadFactoryDemo implements ThreadFactory{
//
//    @Override
//    public Thread newThread(Runnable r) {
//        Thread t = new Thread(r);
//        t.setUncaughtExceptionHandler(new myException());
//        return t;
//    }
//}
