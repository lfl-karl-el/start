package com.example.controller.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.api.entity.StartUserInfo;
import com.example.api.service.dubbo.UserServiceDubbo;
import com.example.api.utils.RedisUtil;
import com.example.controller.anotation.NoRepeatSubmit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Reference
    private UserServiceDubbo userServiceDubbo;

    @NoRepeatSubmit
    @RequestMapping("test")
    public Object test() {
        String userId = "1";
        try {
            userServiceDubbo.getUserInfo(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "enen";
    }
}
