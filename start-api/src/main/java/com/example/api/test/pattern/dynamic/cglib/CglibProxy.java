package com.example.api.test.pattern.dynamic.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor{

    public Object newInstance(Object obj){
        return Enhancer.create(obj.getClass(),this );
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始时间");
        methodProxy.invokeSuper(o,objects);
        System.out.println("结束时间");
        return null;
    }
}
