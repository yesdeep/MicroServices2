package com.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.crud.demo.model.Product;
import com.crud.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getSingleProduct(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
		
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public void updatePrice(double price, Long id) {
		productRepository.updatePrice(price, id);
	}

}
