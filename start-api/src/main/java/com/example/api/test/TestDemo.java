package com.example.api.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>(16);

        map.put("11","11");
        map.put("11","11");
        map.put("11","11");

        map.forEach((key,value) -> {
            System.out.println(key + ":" + value);
        });
    }
}
