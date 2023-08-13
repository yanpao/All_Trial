package com.example.rabbitmq.Fanout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@Profile("fanout")
@CrossOrigin(origins = "*")
@RequestMapping("/fanout")
public class FanoutController {

    @Autowired
    private FanoutSender sender;

    @PostMapping("/send")
    public String sendTest(@RequestParam Integer message) {
        sender.send(message);
        return "ok";
    }
}
