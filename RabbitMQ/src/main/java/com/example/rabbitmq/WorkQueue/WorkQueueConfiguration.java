package com.example.rabbitmq.WorkQueue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("work")
public class WorkQueueConfiguration {

    @Autowired
    private AmqpTemplate template;

    @Bean
    public Queue basicQueue(){
        return new Queue("WorkQueue");
    }

    @Bean
    public WorkReceiver workReceiver1(){
        return new WorkReceiver(template,basicQueue(),"Receiver___1");
    }

    @Bean
    public WorkReceiver workReceiver2(){
        return new WorkReceiver(template,basicQueue(),"Receiver___2");
    }

    @Bean
    public WorkSender workSender(){
        return new WorkSender(template,basicQueue());
    }
}
