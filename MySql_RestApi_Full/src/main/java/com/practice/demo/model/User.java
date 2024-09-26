package com.practice.demo.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString	
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column
	private int id;
	
	@Column
	private String name;
	
	
}
