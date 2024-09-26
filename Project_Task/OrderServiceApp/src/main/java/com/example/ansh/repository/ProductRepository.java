package com.example.ansh.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ansh.beans.Product;

public interface ProductRepository extends CrudRepository<Product, String>{

}
