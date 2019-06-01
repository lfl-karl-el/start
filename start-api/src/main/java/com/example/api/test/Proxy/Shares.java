package com.example.api.test.Proxy;

/**
 * @program: start-Shares
 * @description: 股票
 * @author: Mr.lfl
 * @create: 2019-04-08 12:29
 **/
public class Shares implements Finance{

    @Override
    public void financing(String str) {
        if("1".equals(str)){
            System.out.println("我通过股票来理财");
        }else{
            System.out.println("我没法通过股票来理财");
        }

    }
}
