package com.practice.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
}
