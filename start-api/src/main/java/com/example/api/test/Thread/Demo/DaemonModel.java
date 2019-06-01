package com.example.api.test.Thread.Demo;

import java.util.concurrent.TimeUnit;

/**
 * @program: start-DaemonModel
 * @description:
 * @author: Mr.lfl
 * @create: 2019-05-12 21:02
 **/
public class DaemonModel implements Runnable{

    @Override
    public void run() {
        try {
            while(true){
                TimeUnit.SECONDS.sleep(10);
                System.out.println(Thread.currentThread().getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
//        ExecutorService service = Executors.newCachedThreadPool(new DaemonModalThreadFactory());
//        for(int i= 0;i<10;i++){
//            service.execute((Runnable) new DaemonModalThreadFactory());
//        }
//        System.out.println("print daemon started");
//        TimeUnit.SECONDS.sleep(17);
    }
}
//设置一个ThreadFactory工厂  每一个产生的线程都是后台线程
//class DaemonModalThreadFactory implements ThreadFactory{
//    @Override
//    public Thread newThread(Runnable r) {
//        Thread t = new Thread(r);
//        t.setDaemon(true);
//        return t;
//    }
//}
