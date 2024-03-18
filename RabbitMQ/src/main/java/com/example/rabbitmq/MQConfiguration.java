package com.example.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfiguration {

    public static final String MOMENTS_EXCHANGE = "moments-exchange";
    public static final String MOMENTS_QUEUE = "moments-queue";

    @Bean
    public Queue momentsQueue() {
        return new Queue(MOMENTS_QUEUE);
    }

    @Bean
    public FanoutExchange momentsExchange() {
        return new FanoutExchange(MOMENTS_EXCHANGE);
    }

    @Bean
    public Binding MomentsBinding() {
        return BindingBuilder.bind(momentsQueue()).to(momentsExchange());
    }
}
