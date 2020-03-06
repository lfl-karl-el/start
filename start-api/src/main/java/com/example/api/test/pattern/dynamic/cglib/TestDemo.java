package com.example.api.test.pattern.dynamic.cglib;

public class TestDemo {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        GameService logService = (GameService) cglibProxy.newInstance(new GameService());
        logService.game();
    }
}
