package com.java.example.controllers;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.example.model.Employee;

@RestController
public class TestController {

	private static final Logger LOG = Logger.getLogger(TestController.class.getName());
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);
	
		return emp;
	}

	@RequestMapping(value = "/employeeShow", method = RequestMethod.GET)
	public Object firstPage2() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);
		
		if("emp1".equals(emp.getName())) {
			try {
				throw new Exception("Testing ...............by produser services.....!");
			} catch (Exception e) {
				 LOG.log(Level.INFO, "/employee trying to print exception - &gt; " + e);
				e.printStackTrace();
				return e;
			}
		}
		return emp;
	}
}