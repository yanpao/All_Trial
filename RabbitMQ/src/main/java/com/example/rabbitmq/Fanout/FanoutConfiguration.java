package com.example.rabbitmq.Fanout;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("fanout")
public class FanoutConfiguration {

    @Autowired
    private AmqpTemplate template;

    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("fanout");
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
    public Binding binding1() {
        return BindingBuilder.bind(autoDeleteQueue1()).to(fanout());
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(autoDeleteQueue2()).to(fanout());
    }

    @Bean
    public FanoutReceiver fanoutReceiver(){
        return new FanoutReceiver();
    }

    @Bean
    public FanoutSender fanoutSender(){
        return new FanoutSender(template,fanout());
    }

}
