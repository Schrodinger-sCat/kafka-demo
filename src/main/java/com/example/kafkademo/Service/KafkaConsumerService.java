package com.example.kafkademo.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "message_example", groupId = "group_id")
    public void consumeKafkaMessage(String message){
        System.out.println("Consume: "+message);
    }
}
