package com.practice.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DbDetails {
	@Value("${database.driver}")
	private String driver;
	@Value("${database.username}")
	private String username;
	@Value("${database.password}")
	private String password;
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "DbDetails [driver=" + driver + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
}
