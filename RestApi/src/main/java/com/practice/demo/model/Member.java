package com.practice.demo.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Member {
	
	private int id;

	private String name;
}
