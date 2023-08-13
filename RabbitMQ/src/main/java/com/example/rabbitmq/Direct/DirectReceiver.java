package com.example.rabbitmq.Direct;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class DirectReceiver {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receive1(String in) {
        receive(in, 1);
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receive2(String in) {
        receive(in, 2);
    }

    public void receive(String in, int receiver) {
        System.out.println("instance binging to queue" + receiver + " [x] Received '" + in + "'");
    }
}
