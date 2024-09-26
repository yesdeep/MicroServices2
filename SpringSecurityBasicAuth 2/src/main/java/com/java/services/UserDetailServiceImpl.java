package com.java.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.dao.UserDetailDao;
import com.java.model.UserRequest;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    UserDetailDao userDetailDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRequest userRequest = userDetailDao.fetchUserDetail(username);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userRequest.getRole()));

        User user = new User(userRequest.getUsername(), userRequest.getPassword(), authorities);

        System.out.println("UserDetailServiceImpl  : loadUserByUsername ");

        return user;
    }
}
