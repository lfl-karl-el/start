package com.example.api.test;

import org.hibernate.boot.jaxb.SourceType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: start-CollectionDemo
 * @description: collection是个接口
 * @author: Mr.lfl
 * @create: 2019-03-04 09:36
 **/
public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> c = new HashSet<String>(){
            {
               add("a");add("b");add("c");add("d");add("e");
            }
        };

        Collection<String> c1 = new HashSet<String>(){
            {
                add("a");add("2");add("2");add("3");add("3");
            }
        };

        //collection 是 list。set。queue的父类
        System.out.println(c.size());
        //contains 里面就是一个iterator遍历器
        System.out.println(c.contains("0"));


        Object[] objs = c.toArray();

        //采用迭代器去遍历，只要有重复的都删除
        c.removeAll(c1);

        /*
        *   jdk8里面新的加入流处理
        *   每一次stream操作都会产生新的流，不会影响源数据
        */
        List<String> strList = c.stream().map(String::toUpperCase).collect(Collectors.toList());
        //循环
        strList.stream().forEach(p -> System.out.println(p));
        //过滤器 这里用 == 不知道为什么会有错
        List<String> strNewList = strList.stream().filter(p -> p.equals("A")).collect(Collectors.toList());
        strNewList.stream().forEach(t -> System.out.println(t));
       //后面还有太多，这里介绍最基本几种


        

    }


}
