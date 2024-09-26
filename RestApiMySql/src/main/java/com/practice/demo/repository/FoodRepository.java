package com.practice.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.model.Food;

@Repository
public interface FoodRepository extends CrudRepository<Food, Integer>{
	
}
