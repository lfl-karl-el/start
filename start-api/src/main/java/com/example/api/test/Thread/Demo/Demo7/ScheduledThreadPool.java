package com.example.api.test.Thread.Demo.Demo7;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: start
 * @description:
 * @author: Mr.lfl
 * @create: 2019-05-28 15:29
 **/
public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor service = new ScheduledThreadPoolExecutor(10);

        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        },10,4, TimeUnit.SECONDS);
    }
}
