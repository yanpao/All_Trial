package com.example.rabbitmq.Direct;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("direct")
public class DirectConfiguration {

    @Autowired
    private AmqpTemplate template;

    @Bean
    public DirectExchange direct() {
        return new DirectExchange("direct-ex");
    }

    @Bean
    public Queue autoDeleteQueue1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue2() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding1a(DirectExchange direct, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(direct).with("orange");
    }

    @Bean
    public Binding binding1b(DirectExchange direct, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(direct).with("black");
    }

    @Bean
    public Binding binding2a(DirectExchange direct, Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2).to(direct).with("green");
    }

    @Bean
    public Binding binding2b(DirectExchange direct, Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2).to(direct).with("white");
    }

    @Bean
    public DirectSender directSender(){
        return new DirectSender(template,direct());
    }

    @Bean DirectReceiver directReceiver(){
        return new DirectReceiver();
    }
}
