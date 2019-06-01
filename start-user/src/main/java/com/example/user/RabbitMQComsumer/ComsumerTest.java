package com.example.user.RabbitMQComsumer;

import com.example.api.utils.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ComsumerTest {
    private Logger log = LoggerFactory.getLogger(ComsumerTest.class);

    @RabbitListener(queues = RabbitMQConfig.TOPIC_QUEUE_1)
    public void test(String name){
        log.info("得到信息"+name);
    }
}
