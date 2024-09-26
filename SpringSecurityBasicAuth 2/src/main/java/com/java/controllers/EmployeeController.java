package com.java.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	@GetMapping
	public Employee fetchEmployee() {
		
		Employee employee = new Employee();
		employee.setEmpId("EMP1001");
		employee.setEmpName("David");
		employee.setEmpDesg("Software Develope");
		
		return employee;
	}
}
