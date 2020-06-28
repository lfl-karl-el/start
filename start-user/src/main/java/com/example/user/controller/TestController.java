package com.example.user.controller;

import com.example.api.entity.common.AjaxResult;
import com.example.api.utils.RabbitMQConfig;
import com.example.api.utils.RedisUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("test")
    public AjaxResult test(){
        redisUtil.set("lfl", "test");
        System.out.println(redisUtil.get("lfl"));
        amqpTemplate.convertAndSend(RabbitMQConfig.TOPIC_QUEUE_1,"3");
        return AjaxResult.success("好的");
    }
}

