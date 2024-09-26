package com.practice.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.model.User;
import com.practice.demo.service.UserService;

@RestController
@RequestMapping("/Company")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers() {
	    List<User> users = service.getAllUsers();
	    if (users.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    }
	    return ResponseEntity.ok(users);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<User>> getUsersByName(@PathVariable String name) {
	    List<User> users = service.findUsersByName(name);
	    if (users.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(users);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable int id) {
		Optional<User> user = service.getUserById(id);
		if(user != null) {
			return ResponseEntity.ok(user);
		}
		return (ResponseEntity<Optional<User>>) ResponseEntity.notFound();
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		service.deleteUser(id);
		return ResponseEntity.ok("Product deleted");
	}
	
	@PostMapping("/")
	public ResponseEntity<String> addUser(@RequestBody User user){
		try {
			service.addUser(user);
			return new ResponseEntity<> ("User added", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<> ("User cannot be added", HttpStatus.OK);
		}
		
	}
	
}
