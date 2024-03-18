package com.example.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        System.out.println("推送消息：" + message);
        rabbitTemplate.convertAndSend(MQConfiguration.MOMENTS_EXCHANGE, "", message);
    }

}
