package com.tech.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import com.tech.model.Product;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "java-topic", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void consumer1(Product product) {
        System.out.println("This is first consumer... "+product);
    }

    @KafkaListener(topics = "java-topic", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void consumer2(Product product) {
        System.out.println("This is Second consumer... "+product);
    }
}
