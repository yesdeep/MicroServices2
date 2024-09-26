package com.practice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CommandLineRunnerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CommandLineRunnerApplication.class, args);
		
		System.out.println("main-working");
	
	}

}
