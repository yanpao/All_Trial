package com.example.rabbitmq.Fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class FanoutReceiver {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receive1(Integer in) throws InterruptedException {
        receive(in, 1);
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receive2(Integer in) throws InterruptedException {
        receive(in, 2);
    }

    public void receive(Integer in, int receiver) throws InterruptedException {
        Thread.sleep(in*1000);
        System.out.println("instance " + receiver + " [x] Received '" + in + "'");
    }
}
