package com.practice.demo.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
@Entity
public class Employee {
	@Id
	@Column
	private int employeeId;
	@Column
	private String employeeName;
	@Column
	private int employeeSalary;
	
}
