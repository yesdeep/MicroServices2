package com.crud.demo.test.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.crud.demo.model.Product;
import com.crud.demo.repository.ProductRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class TestRepository {

    @Autowired
    ProductRepository productRepository;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product(1L, "Book", 15, 45);
    }

    @AfterEach
    void tearDown() {
        productRepository.deleteAll();
        product = null;
    }

    @Test
    void testAddManyProducts() {
        Product product1 = new Product(2L, "Chair", 37, 25);
        productRepository.saveAll(Arrays.asList(product, product1));
        List<Product> productList = productRepository.findAll();
        assertThat(productList.get(1).getProductName()).isEqualTo("Chair");
        assertThat(productList.get(0).getQuantity()).isEqualTo(45);
    }
    
    @Test
    void testAddProduct() {
    	product = new Product(1L, "Book", 15, 45);
        productRepository.save(product);
        System.out.println(product);
         Optional<Product> result = productRepository.findById(product.getProductId());
         System.out.println(result);
         Product fetchedProduct = result.get();
        assertEquals(1L, fetchedProduct.getProductId());
        assertThat(fetchedProduct.getProductId()).isEqualTo(1L);
    }

//    -------------
    
    @Test
    void testUpdateProductPrice() {
        productRepository.save(product);
        int updatedRows = productRepository.updatePrice(20.0, product.getProductId());
        Optional<Product> updatedProduct = productRepository.findById(product.getProductId());
        
        assertThat(updatedRows).isEqualTo(1);
        assertThat(updatedProduct.get().getProductPrice()).isEqualTo(20.0);
    }

    
    
    
}
