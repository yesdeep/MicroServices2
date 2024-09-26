package com.tech.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.Product;


@RestController
@RequestMapping("/product")
public class ProductController {

	
	@GetMapping(path = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product getProductDetail(@PathVariable String productId) {
		Product product = new Product();
		product.setProductId(productId);
		product.setProductName("Laptop");
		product.setProductPrice("111000");
	
		return product;
	}
	
	
		@PostMapping
	public Product createProductDetail(@RequestBody Product product) {
		
		product.setProductId("PP1111");
		product.setProductName("Mobile");
		product.setProductPrice("1010");
	
		return product;
	}
}
