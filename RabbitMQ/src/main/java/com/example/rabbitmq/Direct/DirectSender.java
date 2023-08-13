package com.example.rabbitmq.Direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;

public class DirectSender {

    private final AmqpTemplate template;
    private final DirectExchange directExchange;

    public DirectSender(AmqpTemplate template, DirectExchange directExchange) {
        this.template = template;
        this.directExchange = directExchange;
    }

    public void send(String message,String routeKey) {
        this.template.convertAndSend(directExchange.getName(),routeKey, message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
