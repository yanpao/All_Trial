package com.example.rabbitmq.BasicQueue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;

public class BasicSender {

    private final AmqpTemplate template;
    private final Queue queue;

    public BasicSender(AmqpTemplate template,Queue queue){
        this.template = template;
        this.queue = queue;
    }

    public void send(Integer message) {
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
