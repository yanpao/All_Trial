package com.example.rabbitmq.Direct;

import com.example.rabbitmq.Fanout.FanoutSender;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@Profile("direct")
@CrossOrigin(origins = "*")
@RequestMapping("/direct")
public class DirectController {

    @Autowired
    private AmqpTemplate template;

    @Autowired
    private DirectSender sender;

    @PostMapping("/send")
    public String sendTest(@RequestParam String message,@RequestParam String routeKey) {
        sender.send(message,routeKey);
        return "ok";
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


}
