package com.practice.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.demo.model.User;
import com.practice.demo.service.UserService;

@Component
public class UserRunner implements CommandLineRunner{

    @Autowired
    UserService service;    
    
    @Override
    public void run(String... args) throws Exception {
        
        for (int i = 0; i <= 10; i++) {
            String name = "user" + (i);
            service.addUser(new User(i, name));
        }

        System.out.println("runner");
    }
}
