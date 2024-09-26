package com.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.Responses;
import com.tech.model.UserRequest;
import com.tech.util.JwtTokenUtil;

@RestController
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/authenticate")
    public Responses login(@RequestBody UserRequest userRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(),
                userRequest.getPassword()));
        Responses responses = new Responses();
        responses.setToken(jwtTokenUtil.generateToken(userRequest));
        return responses;
    }
}
