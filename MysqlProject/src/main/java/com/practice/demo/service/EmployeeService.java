package com.practice.demo.service;

import com.practice.demo.model.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.demo.dao.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repo;
	
	public List<Employee> getAllEmployees(){
		List<Employee> list = (List<Employee>) repo.findAll();
		return list;
	
	}
	
	public void saveEmployee(Employee employee) {
		repo.save(employee);
	}
	
	public void deleteEmployee(int id)
	{
		repo.deleteById(id);
	}
}
