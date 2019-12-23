package com.example.api.test.pattern.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 
* 是对所有的接口的实现类实现代理，需要代理那个类就传哪个类，代理添加的方法都是一样的
* 
* @Author: lfl
* @Date: 2019/12/20 15:19 
*/ 
public class LogProxyServiceImpl implements InvocationHandler {

    private Object target;

    public Object newInstans(Object target) {
        this.target = target;
        Object obj  = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("日志插入表");
        method.invoke(target, args);
        return null;
    }
}
