package com.example.api.test.Proxy;

/**
 * @program: start-SharesManager
 * @description: 股票经理  针对str是1的情况，没法理财的情况，设置的代理类---这是静态代理
 * @author: Mr.lfl
 * @create: 2019-04-08 12:35
 **/
public class SharesManager implements Finance{
    private Shares shares;

    public SharesManager(Shares shares) {
        this.shares = shares;
    }

    @Override
    public void financing(String str) {
        System.out.println("我是炒股的代理");
        shares.financing("1");
    }
}
