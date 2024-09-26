package com.java.example.controllers;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.java.example.model.Employee;

@RestController
public class ConsumerControllerClient {

	@RequestMapping(value = "/employeeDetail", method = RequestMethod.GET)
	public Employee firstPage() {

		String baseUrl = "http://producer:8091/employee";
		//String baseUrl = "http://localhost:8091/employee";
		//String baseUrl = "http://192.168.99.100:8091/employee";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee> response=null;
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),Employee.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println("Consume-- "+response.getBody());
		return response.getBody();
	}
	


	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}