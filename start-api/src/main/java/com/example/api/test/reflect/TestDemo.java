package com.example.api.test.reflect;

import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
*
*  反射学习
* @Author: lfl
* @Date: 2020/1/8 14:21
*/
public class TestDemo {
    public static void main(String[] args) {

        /*  asSubclass
            将parentClass转换成sonClass类--------------------可以用于判断一个类是不是其他类的实例
        */
        Class son = SonClass.class.asSubclass(ParentClass.class);

        /*
            cast
            只有存在继承关系的对象之间才能强制转换，父类不能强转成子类
         */
        SonClass sonDemo = new SonClass();
        ParentClass parDemo = ParentClass.class.cast(sonDemo);

        /*
            getClasses 获得这个类以及他的父类或者继承类的 内部类
         */
        Class[] allClasses = SonClass.class.getClasses();

        /*
            getDeclareClasses 获得这个类的内部类
         */
        Class[] classes = SonClass.class.getDeclaredClasses();

        /*
             getField 只能获得公告的类，无论是继承的还是自己的
             getDeclaredFields 只能获得自己的
         */
        Field[] fields = SonClass.class.getDeclaredFields();

        /*
            getAnnotations 和 getAnnotation(obj.class)
         */
        Annotation a = SonClass.class.getAnnotation(Component.class);

        Constructor[] constructors = SonClass.class.getConstructors();

        Method[] methods = SonClass.class.getMethods();

    }
}
