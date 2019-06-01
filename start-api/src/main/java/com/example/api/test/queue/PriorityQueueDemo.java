package com.example.api.test.queue;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @program: start-PriorityQueueDemo
 * @description: 优先级队列  使用堆的数据结构,堆是一种可以自我调整的二叉树，每次添加或者删除的时候，总是移动最小的元素到根上
 * @author: Mr.lfl
 * @create: 2019-03-27 11:03
 **/
public class PriorityQueueDemo {
    public static void main(String[] args) {

//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//
//        queue.add(1);
//        queue.add(3);
//        queue.add(6);
//        queue.add(4);
//        queue.add(2);
//        queue.add(10);
//
//       while(!queue.isEmpty()){
//           System.out.println(queue.poll());
//       }

        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<Integer>(5,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                return (int)o2 - (int)o1;
            }
        });

        queue.put(1);
        queue.put(5);
        queue.put(2);
        queue.put(10);
        queue.put(8);

        for(int i=0;i<5;i++){
            System.out.println(queue.poll());
        }
    }

}
