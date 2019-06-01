package com.example.api.utils.FileUtils;

/**
 * @program: start-StringTools
 * @description: 字符串操作类
 * @author: Mr.lfl
 * @create: 2019-03-04 19:12
 **/
public class StringTools {

    //将字符串变成二进制数据
    public String toBinaryString(String origin){
        char[] chars = origin.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for(char c : chars){
            stringBuffer.append(Integer.toBinaryString(c));
        }
        return stringBuffer.toString();
    }
}
