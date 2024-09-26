package com.practice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RestApiApplication.class, args);
		
		
	}

}
