package com.tech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tech.model.Employee;
import com.tech.model.EmployeeHealthInsurance;
import com.tech.service.EmployeeInsuranceService;
import com.tech.service.EmployeeService;
import com.tech.service.OrganizationService;

import java.sql.SQLException;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeInsuranceService employeeInsuranceService;
	
	@Override
	@Transactional(rollbackFor = SQLException.class, propagation = Propagation.REQUIRES_NEW)
	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) throws Exception {
		//BEGIN
		employeeService.insertEmployee(employee);

		if(!"0".equals(employeeHealthInsurance.getEmpId())) {
			employeeInsuranceService.addEmployeeInsuranceDetail(employeeHealthInsurance);	
		}else {
			throw new RuntimeException("Employee Id should not Null or Zero.....");
		}
		
		//commit;
		//END
	}

	
	
}
