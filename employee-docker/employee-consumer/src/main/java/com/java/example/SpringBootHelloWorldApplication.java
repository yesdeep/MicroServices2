package com.java.example;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.java.example.controllers.ConsumerControllerClient;

@SpringBootApplication
public class SpringBootHelloWorldApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(
				SpringBootHelloWorldApplication.class, args);
		
		
		
	}
	
	@Bean
	public  ConsumerControllerClient  consumerControllerClient()
	{
		return  new ConsumerControllerClient();
	}
}