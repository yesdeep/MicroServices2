package com.practice.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Long id;
	
	@Column(nullable = false)
    private String title;
	
	@Column(nullable = false)
    private String author;

}
