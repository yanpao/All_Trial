package com.example.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Autowired
    private CustomProperties customProperties;

    @Bean
    public String tesy(){
        return "sssss";
    }
}
