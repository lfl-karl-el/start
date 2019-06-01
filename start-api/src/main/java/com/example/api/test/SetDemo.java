package com.example.api.test;

import java.util.*;

/**
 * @program: start-SetDemo
 * @description: set
 * @author: Mr.lfl
 * @create: 2019-03-05 15:19
 **/
public class SetDemo {
    public static void main(String[] args) {
        ArrayList<PersonBo> personList = new ArrayList();
        PersonBo p1 = new PersonBo("tom1",16,89.0);
        PersonBo p2 = new PersonBo("tom2",16,90.0);
        PersonBo p3 = new PersonBo("tom3",17,90.0);
        PersonBo p4 = new PersonBo("tom4",15,90.0);
        PersonBo p5 = new PersonBo("tom5",16,100.0);
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);

        //如果treeSet 存的是对象，对象应该实现comparable接口，重写comparator方法
        //treeSet 内部是二叉树，每次存入数据，都会与其它数据进行比较，所以需要给一个具体的比较方法
        //treeSet 每次存入数据都会先比较hashCode，如果相同，再比较equals方法
        //这里对score排序
        TreeSet<PersonBo> treeSet = new TreeSet();
        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        treeSet.add(p4);
        treeSet.add(p5);

        System.out.println(treeSet.pollFirst());

        treeSet.stream().forEach(p -> System.out.println(p));


        //下面是treeSet存储普通的数据类型
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.descendingSet();//这个方法是为了降序
        integerTreeSet.add(2);integerTreeSet.add(99);integerTreeSet.add(-33);integerTreeSet.add(2);
        integerTreeSet.stream().forEach(p -> System.out.println(p));


        /*HashSet*/
        //HashSet是无序的，也是不重复的
        //因为set的存入是无序的，所以他是没有get方法去获得值的
        HashSet<String> hashSet = new HashSet();
        hashSet.add("a");hashSet.add("c");hashSet.add("b");hashSet.add("e");hashSet.add("d");
        Iterator<String> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }

        System.out.println();
        /*LinkedHashSet*/
        //按照放入的顺序存储,它集合了linkedList和set的优点,有序而且不重复
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("la");linkedHashSet.add("lf");linkedHashSet.add("ld");linkedHashSet.add("la");
        linkedHashSet.stream().forEach(p -> System.out.print(p));
    }
}

