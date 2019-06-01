package com.example.api.test;

import java.util.*;

/**
 * @program: start-ListDemo
 * @description: List接口实现Collection接口 这里主要介绍arrayList,linkedList,vector,stack
 * @author: Mr.lfl
 * @create: 2019-03-04 19:45
 **/
public class ListDemo {
    public static void main(String[] args) {

        /**
         * linkedList 可以模拟成栈或者队列来使用   addFirst先加入的放最里面,getFirst取得最后放入的
         */
//        LinkedList list = new LinkedList<>();
//        list.addFirst("1");
//        list.addFirst("2");
//        list.addFirst("3");
//        list.addFirst("4");
//        list.addFirst("5");
//
//        System.out.println(list.getFirst());
//        System.out.println(list.removeFirst());
//        System.out.println(list.getFirst());

        /**
         * stack 后进先出的栈
         */
//        Stack stack = new Stack();
//
//        stack.push("a");
//        stack.push("b");
//        stack.push("c");
//        stack.push("d");
//        stack.push("e");
//
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//
//        System.out.println(stack.search("a"));

        /**
         * 两个链表，a，b ab交叉插入
         */
        LinkedList<String> list1 = new LinkedList<String>();
        list1.add("a");list1.add("b");list1.add("c");list1.add("d");

        LinkedList<String> list2 = new LinkedList<String>();
        list2.add("1");list2.add("2");list2.add("3");list2.add("4");



        ListIterator<String> iterator1 = list1.listIterator();
        Iterator<String> iterator2 = list2.iterator();

        while(iterator1.hasNext()){
            iterator1.next();
            if(iterator2.hasNext()){
                iterator1.add(iterator2.next());
            }
        }

        System.out.println(list1);
    }
}
