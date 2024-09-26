package com.java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.UserDetailDao;
import com.java.model.UserRequest;

@Service
public class UserServiceImpl {
    @Autowired
    UserDetailDao userDetailDao;

    public void createUser(UserRequest userRequest) {
        userDetailDao.createUser(userRequest);
    }
}
