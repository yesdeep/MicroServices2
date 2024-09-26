package com.java.controllers;

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

import com.java.model.UserRequest;
import com.java.services.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public String createUser(@RequestBody UserRequest request) {
        String securePassword = passwordEncoder.encode(request.getPassword());

        //Implicitly adding user info by authentication manager...
        /*List<GrantedAuthority> authorities= new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+request.getRole()));
        User user = new User(request.getUsername(), securePassword, authorities);
        jdbcUserDetailsManager.createUser(user);*/


        //Explicitly adding user using user dao
        request.setPassword(securePassword);
        request.setRole("ROLE_"+request.getRole());
        userServiceImpl.createUser(request);

        return "User created successfully...";
    }
}
