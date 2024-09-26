package com.practice.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.demo.dao.VehicleRepository;
import com.practice.demo.model.Vehicle;

@Component
public class VehicleRunner implements CommandLineRunner{

	@Autowired
	VehicleRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Vehicle(-1,"mani", 789));
		repo.save(new Vehicle(0,"deep", 987));
		
	}
	
}
