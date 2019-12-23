package com.example.api.test;

import com.example.api.test.pattern.dynamic.jdk.LogProxyServiceImpl;
import com.example.api.test.pattern.dynamic.jdk.LogService;
import com.example.api.test.pattern.dynamic.jdk.LogServiceImpl;
import com.example.api.test.pattern.dynamic.jdk.LogTimeServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDemo {
    public static void main(String[] args) {
        LogProxyServiceImpl logProxyService = new LogProxyServiceImpl();
        LogService logService = (LogService)logProxyService.newInstans(new LogTimeServiceImpl());
        logService.exit();
    }
}
