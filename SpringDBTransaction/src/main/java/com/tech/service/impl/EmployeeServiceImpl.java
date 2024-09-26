package com.tech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tech.dao.EmployeeDao;
import com.tech.model.Employee;
import com.tech.service.EmployeeService;

import java.sql.SQLException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	

	@Override
	@Transactional(rollbackFor = SQLException.class, propagation = Propagation.REQUIRES_NEW)
	public void insertEmployee(Employee employee) {
		//BEGIN
		employeeDao.insertEmployee(employee);
		//COMMIT 
	}

}
