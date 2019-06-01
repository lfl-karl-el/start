package com.example.api.test.Thread.Demo.Demo4;

/**
 * @program: start
 * @description:
 * @author: Mr.lfl
 * @create: 2019-05-27 14:16
 **/
public class NeedCleanup {
    private int id;
    public NeedCleanup(int d){this.id=d; }

    public void cleanup(){
        System.out.println("clean up"+id);
    }
}
