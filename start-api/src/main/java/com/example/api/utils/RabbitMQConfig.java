package com.example.api.utils;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig{
    public static final String TOPIC_QUEUE_VERICODE = "topic_queue_vericode";
    public static final String BINDING_KEY_VERICODE = "topic.key.vericode";

    public static final String TOPIC_QUEUE_1 = "topic_queue_1";
    public static final String TOPIC_EXCHANGE = "topic_exchange_1";
    public static final String BINDING_KEY_1 = "topic.*";

    /*测试队列*/
    @Bean
    public Queue getTopicQueue1(){
        return new Queue(TOPIC_QUEUE_1,true);
    }
    /*测试队列*/

    @Bean
    public TopicExchange getExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding exchangeToQueue(){
        return BindingBuilder.bind(getTopicQueue1()).to(getExchange()).with(BINDING_KEY_1);
    }

    /*验证码发送队列*/
    @Bean
    public Queue getTopicQueueVeriCode(){
        return new Queue(TOPIC_QUEUE_VERICODE,true);
    }

    @Bean
    public Binding exchangeToQueueVericode(){
        return BindingBuilder.bind(getTopicQueueVeriCode()).to(getExchange()).with(BINDING_KEY_VERICODE);
    }
    /*验证码发送队列*/


}
