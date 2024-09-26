package com.tech.dao;

import com.tech.model.Employee;

public interface EmployeeDao {
	void insertEmployee(Employee cus);

	void deleteEmployeeById(String empid);
	
	void updateEmployee(Employee emp);
}