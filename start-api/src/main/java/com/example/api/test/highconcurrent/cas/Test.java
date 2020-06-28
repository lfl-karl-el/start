package com.example.api.test.highconcurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.incrementAndGet());

        System.out.println(atomicInteger.get());
    }
}
