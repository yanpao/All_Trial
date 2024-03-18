package com.example.rabbitmq.WorkQueue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "WorkQueue")
public class WorkReceiver {

    private final AmqpTemplate template;
    private final Queue queue;
    private final String receiveName;

    public WorkReceiver(AmqpTemplate template, Queue queue,String receiveName){
        this.template = template;
        this.queue = queue;
        this.receiveName = receiveName;
    }

    @RabbitHandler
    public void receive(Integer in) throws InterruptedException {
        Thread.sleep(in*1000);
        System.out.println(receiveName + " Received_1 '" + in + "'");
    }

    @RabbitHandler
    public void receive2(String in) {
        //Thread.sleep(in*1000);
        System.out.println(receiveName + " Received_2 '" + in + "'");
    }

}
