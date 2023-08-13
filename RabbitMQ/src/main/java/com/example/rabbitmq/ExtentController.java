package com.example.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/extent")
public class ExtentController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Sender sender;

    @PostMapping("/send")
    public String sendTest(@RequestBody Extent extent, HttpServletRequest request) throws JsonProcessingException {
        String mq = objectMapper.writeValueAsString(extent);
        sender.sendMessage(mq);
        return "ok";
    }

    @GetMapping("/receive")
    public String receiveTest(HttpServletRequest request){
        return rabbitTemplate.receiveAndConvert().toString();
    }

    @PostMapping("/new")
    public String newExtent(){
        sender.sendMessage("message");
        return "ok";
    }
}
