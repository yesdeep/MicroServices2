package com.practice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.practice.demo.model.DataSource;

@SpringBootApplication
public class PropertiesFilesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PropertiesFilesApplication.class, args);
		DataSource ds = (DataSource)context.getBean("dataSource");
		System.out.println(ds);
		
	}

}
