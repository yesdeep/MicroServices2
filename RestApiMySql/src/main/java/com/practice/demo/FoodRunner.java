package com.practice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.demo.model.Food;
import com.practice.demo.service.FoodService;

@Component
public class FoodRunner implements CommandLineRunner{
	
	@Autowired
	FoodService service;
	
	@Override
	public void run(String... args) throws Exception {
		service.addFood(new Food(1, "Biryani", 20.00));
		service.addFood(new Food(2, "Pizza", 15.50));
		service.addFood(new Food(3, "Burger", 10.00));
		service.addFood(new Food(4, "Pasta", 12.75));
		service.addFood(new Food(5, "Sushi", 25.00));
		service.addFood(new Food(6, "Tacos", 8.50));
		service.addFood(new Food(7, "Salad", 7.00));
		service.addFood(new Food(8, "Steak", 30.00));
		service.addFood(new Food(9, "Sandwich", 6.50));
		service.addFood(new Food(10, "Noodles", 9.00));
		
		System.out.println("Runner");
		
		
	}

}
