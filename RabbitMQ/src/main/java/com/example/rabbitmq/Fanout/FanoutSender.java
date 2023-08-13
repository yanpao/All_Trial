package com.example.rabbitmq.Fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.FanoutExchange;

public class FanoutSender {

    private final AmqpTemplate template;
    private final FanoutExchange fanout;

    public FanoutSender(AmqpTemplate template, FanoutExchange fanout) {
        this.template = template;
        this.fanout = fanout;
    }

    public void send(Integer message) {
        this.template.convertAndSend(fanout.getName(),"", message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
