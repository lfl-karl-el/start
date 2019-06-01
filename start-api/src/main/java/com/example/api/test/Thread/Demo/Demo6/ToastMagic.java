package com.example.api.test.Thread.Demo.Demo6;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: start
 * @description:
 * @author: Mr.lfl
 * @create: 2019-05-27 16:53
 **/
public class ToastMagic {
    public static void main(String[] args)  throws InterruptedException{
        ToastQueue dryQueue = new ToastQueue(),
                butterQueue = new ToastQueue(),
                jamQueue = new ToastQueue();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Toaster(dryQueue));
        service.execute(new Butterer(dryQueue,butterQueue));
        service.execute(new Jamer(butterQueue,jamQueue));
        service.execute(new Eater(jamQueue));

        TimeUnit.SECONDS.sleep(5);
        /*shutDown 只是会拒绝新的任务，shutDownNow 还会终止在运行的线程任务*/
        service.shutdownNow();
    }
}
class Toast{
    public enum Status {DRY,BUTTERED,JAMMED};
    private Status status = Status.DRY;
    private final int id;
    public Toast(int dtn){
        this.id = dtn;
    }
    public void butter(){status = Status.BUTTERED;}
    public void jum(){status = Status.JAMMED;}
    public Status getStatus(){return status;}

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return "Toast"+id+":"+status;
    }
}
class ToastQueue extends LinkedBlockingQueue<Toast>{}

class Toaster implements Runnable{
    private ToastQueue toastQueue ;
    private int count = 0;
    private Random rand = new Random(47);
    public Toaster(ToastQueue tq){
        this.toastQueue = tq;
    }
    @Override
    public void run(){
        try {
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100 +rand.nextInt(500));
                Toast t = new Toast(count++);
                System.out.println(t);
                toastQueue.put(t);
                System.out.println("toaster off");
            }
        }catch (InterruptedException e){
            System.out.println("toaster interrupted");
        }
    }
}
class Butterer implements Runnable{
    private ToastQueue dryQueue,butterQueue ;
    public Butterer(ToastQueue dry,ToastQueue butter){
        this.dryQueue = dry;
        this.butterQueue = butter;
    }
    @Override
    public void run(){
        try {
            while(!Thread.interrupted()){
                Toast t = dryQueue.take();
                t.butter();
                System.out.println(t);
                butterQueue.put(t);
                System.out.println("butterer off");
            }
        }catch (InterruptedException e){
            System.out.println("butterer interrupted");
        }
    }
}
class Jamer implements Runnable{
    private ToastQueue butterQueueu,finishQueue;
    public Jamer(ToastQueue bq,ToastQueue fq){
        this.butterQueueu = bq;
        this.finishQueue = fq;
    }
    @Override
    public void run(){
        try {
            while(!Thread.interrupted()){

                Toast t = butterQueueu.take();
                t.jum();
                System.out.println(t);
                finishQueue.put(t);
                System.out.println("Jam off");
            }

        }catch(InterruptedException e){
            System.out.println("Jam interrupted");
        }
    }
}
class Eater implements Runnable{
    private ToastQueue finishQueue;
    private int counter = 0;
    public Eater(ToastQueue tq){
        this.finishQueue = tq;
    }
    @Override
    public void run(){
        try {
            while(!Thread.interrupted()){
                Toast t = finishQueue.take();
                if(t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED){
                    System.out.println("制作失败");
                    System.exit(1);
                }else{
                    System.out.println(t.getId()+"制作完成");
                }
            }
        }catch(InterruptedException e){
            System.out.println("Eater Interrupted");
        }
        System.out.println("eat off");
    }
}
