package com.tech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.dao.HealthInsuranceDao;
import com.tech.model.EmployeeHealthInsurance;
import com.tech.service.EmployeeInsuranceService;

@Service
public class EmployeeInsuranceServiceImpl  implements EmployeeInsuranceService{

	@Autowired
	private HealthInsuranceDao healthInsuranceDao; 
	
	@Override
	public void addEmployeeInsuranceDetail(EmployeeHealthInsurance employeeHealthInsurance) {
		healthInsuranceDao.registerEmployeeHealthInsurance(employeeHealthInsurance);
	}
}
