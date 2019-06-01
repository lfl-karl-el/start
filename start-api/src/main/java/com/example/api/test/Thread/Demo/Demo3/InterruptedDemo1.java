package com.example.api.test.Thread.Demo.Demo3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @program: start
 * @description:
 * @author: Mr.lfl
 * @create: 2019-05-27 12:12
 **/
public class InterruptedDemo1 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<?> f = service.submit(new DelayRun(new DelayDemo()));

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        f.cancel(true);
    }
}
class DelayDemo{
    private static final String msg="延迟结束";
    public static String delayMethod(){
        try {
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){
            System.out.println("延迟中断");
            System.exit(0);
        }
        return msg;
    }
}
class DelayRun implements Runnable{
    private DelayDemo delayDemo;

    public DelayRun(DelayDemo demo){
        this.delayDemo = demo;
    }
    @Override
    public void run(){
        DelayDemo.delayMethod();
    }
}
