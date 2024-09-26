package com.practice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.demo.dao.VehicleRepository;
import com.practice.demo.model.Vehicle;

@SpringBootApplication
public class H2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(H2Application.class, args);
		VehicleRepository repo = context.getBean("vehicleRepository", VehicleRepository.class);
		repo.save(new Vehicle(1,"bullet",123));
		repo.save(new Vehicle(2,"re", 321));
	}

}
