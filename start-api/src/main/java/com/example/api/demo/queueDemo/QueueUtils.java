package com.example.api.demo.queueDemo;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
* 模拟mq的工具类，操作放入队列
 * 第一步：请求带上队列名称，该队列已存在就使用，不存在就新加队列再使用
 * 第二步：队列要执行传入的操作
 * 第三步：队列满了就返回提示
* @Author: lfl
* @Date: 2020/3/22 16:45 
*/ 
public class QueueUtils {
    public static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

    /**
     * 队列添加操作
     * date: 2020/3/22 21:29
     * author: lfl
     * @param obj  
     * @return java.lang.String
     */ 
    public static String add(Object obj){
        boolean flag = queue.offer(obj);
        if(flag){
            return "添加成功";
        }
        return "添加失败";
    }
}
