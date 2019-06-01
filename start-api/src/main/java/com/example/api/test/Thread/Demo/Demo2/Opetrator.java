package com.example.api.test.Thread.Demo.Demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: start
 * @description: 统计公园每天通过各个大门的人数，每个门人数增加，总的人数也增加
 * @author: Mr.lfl
 * @create: 2019-05-27 09:22
 **/
public class Opetrator {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        for(int i=0;i<5;i++){
            service.execute(new Entrance(i));
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){

        }
        Entrance.cancle();

        System.out.println(Entrance.getTotalCount());
        System.out.println(Entrance.sumEntrance());
    }
}
