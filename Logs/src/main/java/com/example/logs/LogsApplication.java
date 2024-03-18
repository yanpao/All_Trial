package com.example.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogsApplication {

    static final Logger logger = LoggerFactory.getLogger(LogsApplication.class);

    public static void main(String[] args) {
        logger.info("the logger system commence");
        SpringApplication.run(LogsApplication.class, args);
    }

}
