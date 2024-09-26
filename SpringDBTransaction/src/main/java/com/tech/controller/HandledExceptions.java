package com.tech.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tech.model.Responses;

@RestControllerAdvice
public class HandledExceptions {

	@ExceptionHandler(value = Exception.class)
	public Responses generateException(Throwable ex) {
		Responses response = new Responses();
		response.setStatus("Failed");
		response.setStatusCode("500");
		response.setMessage(ex.getMessage());
		return response;
	}
}
