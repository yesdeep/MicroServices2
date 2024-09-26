package com.tech.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.UserRequest;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private JdbcUserDetailsManager  jdbcUserDetailsManager;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/register")
	public String createUser(@RequestBody UserRequest userRequest) {
		
		String password = bCryptPasswordEncoder.encode(userRequest.getPassword());
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_"+userRequest.getRole()));
		
		User user = new User(userRequest.getUsername(), password, authorities);
		
		jdbcUserDetailsManager.createUser(user);
		
		return "User created successfully";
		
	}
}
