package com.example.api.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @program: start-IteratorModel
 * @description: 迭代器学习
 * @author: Mr.lfl
 * @create: 2019-02-22 10:25
 **/
public class IteratorModel {
    public static void main(String[] args) throws Exception{

        MyIterator myIterator = new MyIterator();
        Iterator<String> iterator = myIterator.iterator();
        while(iterator.hasNext()){
            Thread.sleep(1000);
            System.out.print(iterator.next());
        }
    }

    //普通的iterator
    public static void init() throws Exception{
        Collection<Integer> arrayList = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            arrayList.add(i);
        }
        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            Thread.sleep(1000);
            System.out.print(iterator.next());
        }
    }



}

//自己模拟一个遍历器 遍历器内部是一个数组
class MyIterator implements java.lang.Iterable<String>{

    private String[] str = {"a","b","c"};
    private int lengthNumber = str.length;

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            //游标
            private int cursor = -1;

            @Override
            public boolean hasNext() {
                if( cursor + 1 < lengthNumber){
                    return true;
                }
                return false;
            }

            @Override
            public String next() {
                cursor++;
                return str[cursor];
            }
        };
    }
}
