package com.example.rabbitmq.BasicQueue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class BasicReceiver {

    private final AmqpTemplate template;
    private final Queue queue;

    public BasicReceiver(AmqpTemplate template, Queue queue){
        this.template = template;
        this.queue = queue;
    }

    @RabbitListener(queues = "BasicQueue")
    public void receive(Integer in) throws InterruptedException {
        Thread.sleep(in*1000);
        System.out.println(" [x] Received '" + in + "'");
    }

    public void receive(){
        System.out.println(" [x] Received '" + template.receiveAndConvert(queue.getName()).toString() + "'");
    }

}
