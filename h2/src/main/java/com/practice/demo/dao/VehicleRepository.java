package com.practice.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.model.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle , Integer>{
	
}
