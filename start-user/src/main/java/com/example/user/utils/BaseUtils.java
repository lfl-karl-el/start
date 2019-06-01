package com.example.user.utils;

import java.util.Random;

/**
 * @program: start-BaseUtils
 * @description: 基本工具类
 * @author: Mr.lfl
 * @create: 2019-01-24 09:39
 **/
public class BaseUtils {

    /**
     * 随机获取一定长度的整数
     * @param length
     * @return
     */
    public static String randomNumber(int length){
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i=0;i<length;i++){
            stringBuffer.append(random.nextInt(10));
        }
        return stringBuffer.toString();
    }
}
