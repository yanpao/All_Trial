package com.example.rabbitmq.BasicQueue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("basic")
public class BasicQueueConfiguration {

    //I don't like the way spring encapsulates and injects automatically because it will hide too much crucial details
    @Autowired
    private AmqpTemplate template;

    @Bean
    public Queue basicQueue(){
        return new Queue("BasicQueue");
    }

    @Bean
    public BasicReceiver basicReceiver(){
        return new BasicReceiver(template,basicQueue());
    }

    @Bean
    public BasicSender basicSender(){
        return new BasicSender(template,basicQueue());
    }
}
