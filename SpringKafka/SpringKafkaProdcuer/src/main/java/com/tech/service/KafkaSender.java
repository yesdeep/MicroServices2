package com.tech.service;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.tech.model.Product;

@Service
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;
    private String topic = "java-topic";

    public void sendMessage(Product product) {
        kafkaTemplate.send(topic,product);
        //kafkaTemplate.send(topic,"1" ,product);  // 1 is partition Id
        System.out.println("Message sent successfully to kafka server....");
    }
}
