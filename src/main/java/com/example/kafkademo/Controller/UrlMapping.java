package com.example.kafkademo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlMapping {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC = "message_example";
    @GetMapping("/produce-message/{message}")
    public String produceMessage(@PathVariable("message") String message){
        kafkaTemplate.send(TOPIC, message);
        return "Successful: "+message;
    }
}
