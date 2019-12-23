package com.example.api.test.pattern.dynamic.jdk;

public class TestDemo {
    public static void main(String[] args) {

        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        LogProxyServiceImpl logProxyService = new LogProxyServiceImpl();
        LogService logService = (LogService)logProxyService.newInstans(new LogTimeServiceImpl());



        logService.log();
    }
}
