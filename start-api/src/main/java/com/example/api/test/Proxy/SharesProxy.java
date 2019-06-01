package com.example.api.test.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: start-SharesProxy
 * @description: 动态代理类  jdk的动态代理类
 * @author: Mr.lfl
 * @create: 2019-04-08 16:12
 **/
public class SharesProxy implements InvocationHandler{

    private Object target;

    public Object getObject(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
    }

}
