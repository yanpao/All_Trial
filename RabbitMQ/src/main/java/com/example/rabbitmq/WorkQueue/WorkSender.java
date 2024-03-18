package com.example.rabbitmq.WorkQueue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;

public class WorkSender {

    private final AmqpTemplate template;
    private final Queue queue;

    public WorkSender(AmqpTemplate template, Queue queue){
        this.template = template;
        this.queue = queue;
    }

    public void send(Integer message) {
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }

    public void send(String message) {
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
