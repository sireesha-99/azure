package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

    private static final String DESTINATION_NAME = "demoqueue";

    private static final Logger logger = LoggerFactory.getLogger(SendController.class);
    
    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/messages")
    public String postMessage (@RequestParam String message) {
        logger.info("Sending message");
        jmsTemplate.convertAndSend(DESTINATION_NAME, "Hello World");
        return "sucess";
    }
}