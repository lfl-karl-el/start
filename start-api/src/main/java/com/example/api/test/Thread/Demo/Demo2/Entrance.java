package com.example.api.test.Thread.Demo.Demo2;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @program: start
 * @description: 门 每个门增加的人数增加，总的计数器也增加
 * @author: Mr.lfl
 * @create: 2019-05-27 09:37
 **/
public class Entrance implements Runnable{
    private static Count count = new Count();

    public static ArrayList<Entrance> list = new ArrayList<>();

    public static boolean isCancle = false;
    public static void cancle(){isCancle = true;};
    private int number = 0;
    private int id;

    public Entrance(int id  ){
        this.id = id;
        list.add(this);
    }
    @Override
    public void run(){
        while(!isCancle){

            Random random = new Random();
            int num = random.nextInt(10);
            number = number + num;

            System.out.println(this+"total:"+count.incrment(num));

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            }catch (InterruptedException e){
                System.out.println("sleep interrupted");
            }
        }
    }

    public synchronized int getValue(){
        return number;
    }

    public String toString(){
        return "entrance:"+id+ "数量:"+getValue();
    }

    public static int getTotalCount(){
        return count.value();
    }

    public static int sumEntrance(){
        int sum = 0;
        for(Entrance entrance:list){
            sum +=entrance.getValue();
        }
        return sum;
    }

}
