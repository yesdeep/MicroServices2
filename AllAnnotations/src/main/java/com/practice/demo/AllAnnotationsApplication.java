package com.practice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.practice.demo.model.Support;
import com.practice.demo.model.School;

@SpringBootApplication
public class AllAnnotationsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AllAnnotationsApplication.class, args);
		School school =context.getBean("school", School.class);
		System.out.println(school);
		
		System.out.println("");
		Support support1 = context.getBean("support",Support.class);
        Support support2 = context.getBean("support",Support.class);
        System.out.println("Support instance 1: " + support1);
        System.out.println("Support instance 2: " + support2);
	}

	@Bean
	Support support() {
		Support support = new Support();
		support.setSupportName("mgm");
		return support;
		
	}
	
	
}
