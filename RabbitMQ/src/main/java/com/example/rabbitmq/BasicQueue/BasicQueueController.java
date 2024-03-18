package com.example.rabbitmq.BasicQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@Profile("basic")
@CrossOrigin(origins = "*")
@RequestMapping("/basic")
public class BasicQueueController {

    @Autowired
    private BasicSender sender;

    @Autowired
    private BasicReceiver receiver;

    @PostMapping("/send")
    public String sendTest(@RequestParam Integer message) {
        sender.send(message);
        return "ok";
    }

    @GetMapping("/receive")
    public String receiveTest(){
        receiver.receive();
        return "ok";
    }

}
