package com.tech.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.tech.model.Product;
import com.tech.service.KafkaSenderInterceptor;

@Configuration
@EnableKafka
public class KafkaConfiguration {


	@Bean
	public ProducerFactory<String, Product> producerFactory(){
		Map<String, Object> configs = new HashMap<>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		//configs.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, KafkaSenderInterceptor.class.getName());
		//configs.put(ProducerConfig.RETRIES_CONFIG, 3);
		//configs.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 1000);
		return new DefaultKafkaProducerFactory<>(configs);
	}

	@Bean
	KafkaTemplate<String, Product> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}


}
