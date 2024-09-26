package com.tech.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tech.model.UserRequest;
import com.tech.util.JwtTokenUtil;

@Component
public class JwtRequestFilter  extends OncePerRequestFilter{

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String requestToken = request.getHeader("Authorization");
        String jwtToken = null, username = null;
        if (requestToken != null && requestToken.startsWith("Bearer")) {
            jwtToken = requestToken.substring(7);
            username = jwtTokenUtil.getUserName(jwtToken);
        }
        if (username != null){
            if (!jwtTokenUtil.isTokenExpired(jwtToken)) {
                UserRequest userRequest = jwtTokenUtil.getUserDetailWithRole(jwtToken);

                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(userRequest.getRole()));

                UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(
                        userRequest.getUsername(), null, authorities);
                user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(user);

            }
        }
        filterChain.doFilter(request, response);
    }
}

//Bearer eyJhbGciOiJIUzM4NCJ9.eyJST0xFIjoiUk9MRV9BRE1JTiIsInN1YiI6IlZpbnNodSIsImV4cCI6MTcyNjUwMjMwOCwiaWF0IjoxNzI2NTAxOTQ4LCJqdGkiOiItMTczMjQ5OTczOSJ9.FlUcyXhvegZ-RvQKccsOy5ui_1yans03GxKnWaWgHIkZjkLre8TTLGszp6qRG9_-