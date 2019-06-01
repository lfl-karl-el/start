package com.example.api.test.Thread.Demo.Demo1;

/**
 * @program: start
 * @description:
 * @author: Mr.lfl
 * @create: 2019-05-20 11:38
 **/
public class EvenGenator extends IntGenerator{
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EventChecker.test(5,new EvenGenator());
    }
}
