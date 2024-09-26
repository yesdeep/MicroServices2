package com.tech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	@GetMapping()
	public Employee fetchEmployee() {
		
		Employee employee = new Employee();
		employee.setEmpId("EMP1001");
		employee.setEmpName("Elis");
		employee.setEmpDesg("Software Develope");
		
		return employee;
	}
}
