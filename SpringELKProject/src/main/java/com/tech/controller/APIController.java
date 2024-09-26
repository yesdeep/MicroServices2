package com.tech.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tech.model.User;

@RestController
@RequestMapping("/user")
public class APIController {

	@Autowired
	RestTemplate restTemplate;
		
	String URL = "https://jsonplaceholder.typicode.com/users/";
	
	@GetMapping(value = "/fetch")
	public List<User> fetch() {
		
		User[] user = restTemplate.getForObject(URL, User[].class);
		
		return Arrays.asList(user);
	}
	
	@GetMapping(value = "/fetch2")
	public List<Map<String, String>> fetch2() {
		
		List<Map<String, String>> list = new ArrayList<>();
		
		User[] user = restTemplate.getForObject(URL, User[].class);
		
		for(User usr : Arrays.asList(user)) {
			Map<String, String> map = new HashMap<>();
			map.put("username", usr.getUsername());
			map.put("email", usr.getEmail());
			map.put("zipcode", usr.getAddress().getZipcode());
			list.add(map);
			
		}
				
		return list;
	}
}
