package com.crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.crud.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Modifying
	@Query("update Product p set p.productPrice = :productPrice where p.productId = :productId")
	int updatePrice(@Param(value = "productPrice") double productPrice, @Param(value = "productId") Long productId);

}
