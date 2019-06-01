package com.example.api.test.Thread.Demo.Demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: start
 * @description:
 * @author: Mr.lfl
 * @create: 2019-05-20 11:16
 **/
public class EventChecker implements Runnable{
    private IntGenerator intGenator;
    public EventChecker(IntGenerator i){
        this.intGenator = i;
    }

    @Override
    public void run(){
        while(!intGenator.isCancle()){
            try {

                TimeUnit.SECONDS.sleep(1);
                int val = intGenator.next();
                System.out.println(val);
                if(val%2 != 0){
                    System.out.println(val + "not even");
                    intGenator.cancle();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void test(int count,IntGenerator generator){
        ExecutorService service =  Executors.newCachedThreadPool();

        for(int i=0;i<count;i++){
            service.execute(new EventChecker(generator));
        }
        service.shutdown();
    }

}
