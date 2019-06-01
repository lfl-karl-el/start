package com.example.api.test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @program: start-LinkIteratorModel
 * @description: ListIterator  只能用于list类型，可以实现逆向遍历
 * @author: Mr.lfl
 * @create: 2019-03-04 09:16
 **/
public class LinkIteratorModel {

    public static void main(String[] args) {
        List<String> strList = new LinkedList<>();
        strList.add("1");
        strList.add("2");
        strList.add("3");
        strList.add("4");
        strList.add("5");
        strList.add("6");
        strList.add("7");

        ListIterator iterator = strList.listIterator();
        iterator.hasNext();//如果有下一个元素
        iterator.next();//获得下一个元素
        iterator.hasPrevious();//如果前一个元素有值
        iterator.previous();//获取前一个值
        //除了可以逆向遍历外，还可以修改值和设置值
        iterator.set("8");
        iterator.add("9");

    }
}
