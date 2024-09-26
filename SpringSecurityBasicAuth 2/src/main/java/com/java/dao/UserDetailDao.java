package com.java.dao;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.model.Authorities;
import com.java.model.UserRequest;
import com.java.model.Users;

@Repository
public class UserDetailDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void createUser(UserRequest userRequest) {

        String insertIntoUsers="INSERT INTO users (USERNAME, PASSWORD, ENABLED) VALUES (?,?,?)";
        String insertIntoAuthorities="INSERT INTO authorities (USERNAME, AUTHORITY) VALUES (?,?)";

        jdbcTemplate.update(insertIntoUsers, userRequest.getUsername(), userRequest.getPassword(), 1);
        jdbcTemplate.update(insertIntoAuthorities, userRequest.getUsername(), userRequest.getRole());
        System.out.println("UserDetailDao : createUser... ");
    }

    public UserRequest fetchUserDetail(String userName) {

        System.out.println("UserDetailDao : fetchUserDetail--1");

        UserRequest userRequest = new UserRequest();

        String sql1 = " SELECT * FROM users WHERE username = '" + userName + "'";
        String sql2 = " SELECT * FROM authorities WHERE username = '" + userName + "'";

        Users userResult = jdbcTemplate.queryForObject(sql1, (ResultSet rs, int row) -> {
            Users users = new Users();
            users.setUsername(rs.getString("USERNAME"));
            users.setPassword(rs.getString("PASSWORD"));
            users.setEnable(rs.getString("ENABLED"));
            return users;
        });

        Authorities authoritiesResult = jdbcTemplate.queryForObject(sql2, (ResultSet rs, int row) -> {
            Authorities authorities = new Authorities();
            authorities.setUsername(rs.getString("USERNAME"));
            authorities.setAuthority(rs.getString("AUTHORITY"));
            return authorities;
        });
        userRequest.setUsername(userResult.getUsername());
        userRequest.setPassword(userResult.getPassword());
        userRequest.setRole(authoritiesResult.getAuthority());

        System.out.println("UserDetailDao : fetchUserDetail --2");
        return userRequest;
    }

}

