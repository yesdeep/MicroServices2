package com.practice.demo.model;

import org.springframework.context.annotation.Scope;

import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("unused")
@Setter
@Scope("singleton")
public class Support {
	
	private String supportName;
	
}
