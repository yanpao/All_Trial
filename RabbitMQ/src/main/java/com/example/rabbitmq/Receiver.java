package com.example.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = MQConfiguration.MOMENTS_QUEUE)
    public void receive(String message) {
        System.out.println("消费消息：" + message);
    }

}
