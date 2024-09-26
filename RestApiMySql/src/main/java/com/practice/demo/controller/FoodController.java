package com.practice.demo.controller;

import com.practice.demo.model.Food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.service.FoodService;

@RestController
public class FoodController {
	
	@Autowired
	FoodService service;
	
	@GetMapping("/getall")
	public List<Food> getAllFood() {
		return service.getAllFood();
	}
	
	@PostMapping("/addfood")
	public String addFood(@RequestBody Food food) {
		service.addFood(food);
		return "Food is added";
	}
	
	@DeleteMapping("/deletefood/{id}")
	public String deleteFood(@PathVariable int id) {
		service.deleteFood(id);
		return "Food with id "+ id + " is deleted";
	}
	
	@PutMapping("/editfood")
	public String editFood(@RequestBody Food food) {
		service.editFood(food);
		return "Food with id "+ food.getId() + " is edited";
	}
	
	
	
	
}
