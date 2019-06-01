package com.example.api.test.queue;

import java.util.concurrent.*;

/**
 * @program: start-QueueDemo
 * @description: 队列
 * @author: Mr.lfl
 * @create: 2019-03-07 13:56
 **/
public class QueueDemo {
    public static void main(String[] args) throws Exception{
    /*
    *  queue 分为Deque，非堵塞队列（AbstractQueue）和堵塞队列（BlockingQueue）
    *  其中堵塞队列又有五种（arrayBlockingQueue，LinkedBlockQueue，PriorityBlockingQueue，delayQueue，synchronizedQueue）这几个都是线程安全的
    *   queue的 put方法和take方法 有堵塞效果，add和remove会抛出异常
    *   offer，poll可以等待一段时间
    *   peek方法是获得值后删除这个值，poll只是得到
    * */
    //ArrayBlockingQueue 有界
        ArrayBlockingQueue arrayQueue = new ArrayBlockingQueue(10);



    //LinkedBolckingQueue 可以是无界的队列，是阻塞的，ConcurrentLinkedQueue 是并发的非堵塞的队列
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();

        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();


    //DelayQueue支持延时获取元素的无界阻塞队列
        DelayQueue<DelayModel> delayQueue = new DelayQueue<DelayModel>();
        DelayModel delayModel1 = new DelayModel(2,"lfl",1000);
        DelayModel delayModel2 = new DelayModel(1,"syf",6000);
        DelayModel delayModel3 = new DelayModel(4,"syf",7000);
        DelayModel delayModel4 = new DelayModel(5,"syf",8000);
        DelayModel delayModel5 = new DelayModel(3,"yf",10000);

        delayQueue.offer(delayModel1);delayQueue.offer(delayModel2);delayQueue.offer(delayModel3);
        delayQueue.offer(delayModel4);delayQueue.offer(delayModel5);
        while(true){
            System.out.println(delayQueue.take());
            if(delayQueue.isEmpty()){
                return ;
            }
        }
    }
}

class DelayModel implements Delayed{
    int id;
    String name;
    long time;

    public DelayModel(int id,String name, long time) {
        this.id = id;
        this.name = name;
        this.time = TimeUnit.NANOSECONDS.convert(time, TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.time - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    //这里就是检索队列的顺序,先按照这里规定的顺序，然后再看有没有过期
    @Override
    public int compareTo(Delayed delayed) {
        DelayModel model = (DelayModel)delayed;
        return this.id > model.id ? 1 : (this.id < model.id ? -1 : 0);
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

    @Override
    public String toString() {
        return "DelayModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}