package com.example.rabbitmq.Topic;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("topic")
public class TopicConfiguration {

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("topic");
    }



}
