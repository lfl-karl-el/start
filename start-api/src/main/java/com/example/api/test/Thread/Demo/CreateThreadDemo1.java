package com.example.api.test.Thread.Demo;

/**
 * @program: start-CreateThreadDemo1
 * @description: 例子一
 * @author: Mr.lfl
 * @create: 2019-05-11 22:47
 **/
public class CreateThreadDemo1 extends Thread{

//    private Thread t = new Thread(this);
    public CreateThreadDemo1(){this.start();};

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"打印消息");
    }

    public static void main(String[] args) {
        CreateThreadDemo1 demo = new CreateThreadDemo1();
//        demo.start();
    }
}
