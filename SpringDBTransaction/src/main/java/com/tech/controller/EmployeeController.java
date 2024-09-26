package com.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.Employee;
import com.tech.model.EmployeeHealthInsurance;
import com.tech.service.OrganizationService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private OrganizationService organizationService; 
	
	@PostMapping
	public String createEmployee(@RequestBody Employee employee) throws Exception{
		EmployeeHealthInsurance employeeHealthInsurance = new EmployeeHealthInsurance();
		employeeHealthInsurance.setEmpId(employee.getEmpId());
		employeeHealthInsurance.setHealthInsuranceSchemeName(employee.getHealthInsuranceSchemeName());
		employeeHealthInsurance.setCoverageAmount(employee.getCoverageAmount());
		
		organizationService.joinOrganization(employee, employeeHealthInsurance);
		
		return "Employee Created successfully....";
	}
	
	@PutMapping
	public String updateEmployee(@RequestBody Employee employee) {
		
		
		return "Employee Updated successfully....";
	}
	
}
