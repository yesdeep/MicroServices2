package com.practice.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
@Primary
public class Student1 extends Student {
	
	@Value("Deep")
	private String studentName;
	
}