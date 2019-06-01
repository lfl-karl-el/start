package com.example.api.test.Thread.Demo.Demo10;

/**
 * @program: start
 * @description:
 * @author: Mr.lfl
 * @create: 2019-05-31 15:18
 **/
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton(){

    }

    public static Singleton instance(){
            return singleton;
    }
}
class test{
    public static void main(String[] args) {
        Singleton s1 = Singleton.instance();
        Singleton s2 = Singleton.instance();

        System.out.println(s1 == s2);
    }
}
