package com.example.api.test.Thread.Demo.Demo5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: start
 * @description: 使用wait 和notify notifyAll 模拟交替执行线程的过程，场景是给汽车打蜡和抛光
 * @author: Mr.lfl
 * @create: 2019-05-27 14:55
 **/
public class WaxOMatic {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Car car = new Car();
        service.execute(new WaxOn(car));
        service.execute(new Buffer(car));
    }
}

class Car{
    private boolean waxOn = false;
    private int num = 5;
    public synchronized void waxed(){
        waxOn = true;
        notifyAll();
    }
    public synchronized void buffer(){
        waxOn = false;
        notifyAll();
    }
    public synchronized void waitForWax() throws InterruptedException{
        while(waxOn == false){
            wait();
        }
    }
    public synchronized void waitForBuffer() throws InterruptedException{
        while(waxOn == true){
            wait();
        }
    }
}
//打蜡
class WaxOn implements Runnable{
    private Car car;
    public WaxOn(Car car){
        this.car = car;
    }
    @Override
    public void run(){
        while(!Thread.interrupted()){
            try {
                System.out.println("打蜡好了，开始抛光");
                TimeUnit.SECONDS.sleep(1);
                car.waxed();
                car.waitForBuffer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//抛光
class Buffer implements Runnable{
    private Car car;
    public Buffer(Car car){
        this.car = car;
    }
    @Override
    public void run(){
        while(!Thread.interrupted()){
            try {
                car.waitForWax();
                System.out.println("抛光好了，开始打蜡");
                TimeUnit.SECONDS.sleep(1);
                car.buffer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}