package com.example.api.utils;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: start-SMSUtils
 * @description: 短信发送
 * @author: Mr.lfl
 * @create: 2019-01-23 15:49
 **/
public class SmsUtils {

    private static Logger log = LoggerFactory.getLogger(SmsUtils.class);

    public static void main(String[] args)throws Exception
    {

        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
        //在头文件中设置转码
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");
        NameValuePair[] data ={ new NameValuePair("Uid", "lupo"),new NameValuePair("Key", "d41d8cd98f00b204e980"),new NameValuePair("smsMob","15988801394"),new NameValuePair("smsText","验证码：8888")};
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:"+statusCode);
        for(Header h : headers)
        {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        //打印返回消息状态
        log.info(result);


        post.releaseConnection();

    }
}
