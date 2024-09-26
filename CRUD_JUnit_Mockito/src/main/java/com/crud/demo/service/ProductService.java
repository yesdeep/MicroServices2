package com.crud.demo.service;

import java.util.List;
import java.util.Optional;
import com.crud.demo.model.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	Optional<Product> getSingleProduct(Long id);
	Product createProduct(Product product);
	void deleteProduct(Long id);
	void updatePrice(double price, Long id);

}
