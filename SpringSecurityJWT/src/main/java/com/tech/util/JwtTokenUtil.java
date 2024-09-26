package com.tech.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tech.model.UserRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

    String secertKey = "apolis";

    public String generateToken(UserRequest userRequest) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("ROLE", "ROLE_" + userRequest.getRole());

        String token = Jwts.builder().setClaims(claims).setSubject(userRequest.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 100))
                .setId(String.valueOf(userRequest.getUsername().hashCode()))
                .signWith(SignatureAlgorithm.HS384, secertKey).compact();
        return token;
    }

    public String getUserName(String token) {
        Claims claims = Jwts.parser().setSigningKey(secertKey).parseClaimsJws(token).getBody();
        String username = claims.getSubject();
        return username;
    }

    public Boolean isTokenExpired(String token) {
        Claims claims = Jwts.parser().setSigningKey(secertKey).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date());
    }

    public UserRequest getUserDetailWithRole(String token) {
        Claims claims = Jwts.parser().setSigningKey(secertKey).parseClaimsJws(token).getBody();
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername(claims.getSubject());
        userRequest.setRole(String.valueOf(claims.get("ROLE")));
        return userRequest;
    }
}