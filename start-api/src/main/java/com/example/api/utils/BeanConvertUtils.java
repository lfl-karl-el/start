package com.example.api.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BeanConvertUtils {

    public static Object mapToObject(Map<String,Object> map,Object object){
        try {
            BeanUtils.populate(object,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static Object mapToMap(Map<Object,Object> map,Class<?> class1,Class<?> class2){
        Map resultMap = new HashMap();
        map.forEach( (key,value) ->{
            try {
                resultMap.put( (String)key,value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return resultMap;
    }

    public static void main(String[] args) {
        Map<Object,Object> map = new HashMap<>(8);
        map.put("name","lfl");
        map.put("age",12);

        Map<String,Object> resultmap = (Map<String,Object>)BeanConvertUtils.mapToMap(map,String.class,String.class);
        System.out.println(1);
    }
}
