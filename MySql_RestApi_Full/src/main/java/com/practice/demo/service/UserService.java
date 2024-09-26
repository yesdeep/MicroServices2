package com.practice.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.demo.dao.UserRepository;
import com.practice.demo.model.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public List<User> findUsersByName(String name) {
	    return repo.findUsersByName(name);
	}
	
	public List<User> getAllUsers(){
		System.out.println("All users returned");
		return (List<User>) repo.findAll();
	}
	
	public String addUser(User user) {
		repo.save(user);
		return "User with id "+ user.getId() +" is added";
	}
	
	public String deleteUser(int id) {
		repo.deleteById(id);
		return "User with id "+ id +" is deleted";
	}
	
	public String updateUser(User user) {
		repo.deleteById(user.getId());
		repo.save(user);
		return "User with id "+ user.getId() +" is updated";
	}

	public Optional<User> getUserById(int id) {
		return repo.findById(id);
	}
	
}
