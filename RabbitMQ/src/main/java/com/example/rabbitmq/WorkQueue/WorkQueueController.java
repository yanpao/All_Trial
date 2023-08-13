package com.example.rabbitmq.WorkQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@Profile("work")
@CrossOrigin(origins = "*")
@RequestMapping("/work")
public class WorkQueueController {

    @Autowired
    private WorkSender sender;

    @PostMapping("/send")
    public String sendTest(@RequestParam Integer message) {
        sender.send(message);
        return "ok";
    }

    @PostMapping("/send2")
    public String sendTest(@RequestParam String message) {
        sender.send(message);
        return "ok";
    }
}
