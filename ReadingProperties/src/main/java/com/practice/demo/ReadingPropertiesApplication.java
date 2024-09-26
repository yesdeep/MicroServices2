package com.practice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.practice.model.DbDetails;

@SpringBootApplication
@ComponentScan("com.practice")
@PropertySource({"classpath:dbProps.properties"})
public class ReadingPropertiesApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ReadingPropertiesApplication.class, args);
		
		ApplicationContext context = SpringApplication.run(ReadingPropertiesApplication.class, args);
		DbDetails details = context.getBean("dbDetails", DbDetails.class);
		
		System.out.println(details);
	}

}
