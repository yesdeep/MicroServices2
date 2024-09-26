package com.tech.service;

import com.tech.model.Employee;
import com.tech.model.EmployeeHealthInsurance;

public interface OrganizationService {

	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance)throws Exception;
}
