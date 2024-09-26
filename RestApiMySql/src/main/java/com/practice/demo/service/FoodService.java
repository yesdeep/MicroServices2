package com.practice.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.demo.model.Food;
import com.practice.demo.repository.FoodRepository;

@Service
public class FoodService {
	
	@Autowired
	FoodRepository repo;
	
	public List<Food> getAllFood(){
		List<Food> list = (List<Food>) repo.findAll();
		return list;
	
	}
	
	public void addFood(Food food) {
		repo.save(food);
	}
	
	public void deleteFood(int id) {
		repo.deleteById(id);
	}
	
	public void editFood(Food food) {
		for(Food food2 : (List<Food>) repo.findAll()) {
			if(food2.getId()== food.getId()) {
				repo.deleteById(food.getId());
				repo.save(food);
			}
		}
	}
	
}
