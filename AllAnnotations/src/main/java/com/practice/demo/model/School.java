package com.practice.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class School {
	
	@Value("Alphores")
	private String schoolName;
	
	@Autowired
	Student student;
	
	@Autowired
	@Qualifier("teacher2")
	Teacher teacher;
	
	@Autowired
	Support support;
	

}
