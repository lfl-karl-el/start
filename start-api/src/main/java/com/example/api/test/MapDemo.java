package com.example.api.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: start-MapDemo
 * @description: map集合类
 * @author: Mr.lfl
 * @create: 2019-03-07 09:21
 **/
public class MapDemo {
    public static void main(String[] args) {
        HashMap<Object,String> hashMap = new HashMap();
        hashMap.put(null,"1");
        hashMap.put(null,"1");
        hashMap.put(1,"2");
        hashMap.put(1,"3");

        for(Map.Entry<Object,String> entry: hashMap.entrySet()){
            System.out.println(entry.getKey()+","+entry.getValue());
        }

        /*LinkedHashMap  是为了按照存入顺序存储*/

       Map<Object,String> map = Collections.synchronizedMap(hashMap);

    }
}
