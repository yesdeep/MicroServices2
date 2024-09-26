package com.practice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.practice.demo.model.Employee;
import com.practice.demo.service.EmployeeService;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan("com.practice.demo")
public class MysqlProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MysqlProjectApplication.class, args);
		EmployeeService service = (EmployeeService) context.getBean("employeeService");
		
		service.saveEmployee(new Employee(1,"mani",10));
		service.saveEmployee(new Employee(2,"deep",20));
		service.saveEmployee(new Employee(3,"manideep",30));
		
		System.out.println(service.getAllEmployees());
		
		service.deleteEmployee(1);
		
		System.out.println(service.getAllEmployees());
		
		
	}

}
