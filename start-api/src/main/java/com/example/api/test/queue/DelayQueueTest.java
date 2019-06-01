package com.example.api.test.queue;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @program: start-DelayQueueTest
 * @description: 模拟一个考试的日子，考试时间为30秒，5秒后才可交卷，当时间到了，或学生都交完卷了考试结束。
 * @author: Mr.lfl
 * @create: 2019-03-20 15:40
 **/
public class DelayQueueTest {
    static int num = 30;
    public static void main(String[] args) throws Exception {
        DelayQueue<Task> delayQueue = new DelayQueue<>();
        CountDownLatch latch = new CountDownLatch(30);

        Task task1 = new Task(1,"1");delayQueue.offer(task1);
        Task task2 = new Task(2,"2");delayQueue.offer(task2);
        Task task3 = new Task(3,"3");delayQueue.offer(task3);
        Task task4 = new Task(4,"4");delayQueue.offer(task4);
        Task task5 = new Task(5,"5");delayQueue.offer(task5);

//        for(int i=0;i<25;i++){
//            delayQueue.offer(new Task(i,"name"+i));
//        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("考试开始");
                    while(true){
                        if(num == 0){
                            System.out.println("考试结束");
                            return ;
                        }else{
                            System.out.println(delayQueue.take());
                        }

                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i=0;i< 30;i++){
                        Thread.sleep(1000);
                        System.out.println(i);
                        num--;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
/**
 * 任务类 --- 明确任务，开始执行时间 ,过期策略
 */
class Task implements Delayed{

    private int id;//学生ID
    private String name;//学生名字
    private long time;//考试时间，初始化5 秒
    private int state;//考试状态 1在考 2考完

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.state = 1;
        this.time = TimeUnit.MILLISECONDS.convert(new Random().nextInt(45)+5,TimeUnit.SECONDS)+System.currentTimeMillis();
    }

    @Override  //返回负数说明到期
    public long getDelay(TimeUnit unit) {
        return unit.MILLISECONDS.convert(time-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override  //
    public int compareTo(Delayed o) {
        Task t = (Task)o;
        if(this.time > t.getTime()){
            return 1;
        }else if(this.time < t.getTime()){
            return -1;
        }
        return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", state=" + state +
                '}';
    }
}

