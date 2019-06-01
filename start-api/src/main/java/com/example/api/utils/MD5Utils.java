package com.example.api.utils;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;

/**
 * @program: start-MD5Utils
 * @description: md5加密解密技术
 * @author: Mr.lfl
 * @create: 2019-01-07 16:49
 **/
@Component
public class MD5Utils {
    private static final String ENCODE_STR="MD5";

    public static String encode(String str){
        String returnStr = "";
        try {
            MessageDigest instance = MessageDigest.getInstance(ENCODE_STR);
            byte[] bytes = instance.digest(str.getBytes("UTF-8"));
            returnStr = bytesToString(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnStr;
    }

    public static String bytesToString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(encode("787777"));
    }
}
