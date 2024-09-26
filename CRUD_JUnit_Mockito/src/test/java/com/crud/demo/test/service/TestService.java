package com.crud.demo.test.service;

import com.crud.demo.model.Product;
import com.crud.demo.repository.ProductRepository;
import com.crud.demo.service.ProductServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class TestService {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    private Product product1;
    private Product product2;
    private List<Product> productList;

    @BeforeEach
    void setUp() {
        product1 = new Product((long) 1, "Book", 15, 45);
        product2 = new Product(2L, "Chair", 37, 25);
        productList = Arrays.asList(product1, product2);
    }

    @AfterEach
    void tearDown() {
        product1 = product2 = null;
        productList = null;
    }

    @Test
    void testAddProduct() {
        when(productRepository.save(any())).thenReturn(product1);
        productService.createProduct(product1);
        verify(productRepository).save(any()); // Verify that the mocked productRepository's save() method ran once
        verify(productRepository, times(1)).save(any()); // Equivalent to previous one
        verify(productRepository, atLeastOnce()).save(any()); // Verifies that save() was called at least once
    }

    @Test
    void testFindAllProducts() {
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> list = productService.getAllProducts();
        assertEquals(productList, list);
        verify(productRepository).findAll();
    }

    @Test
    void testFindProductById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));
        assertThat(productService.getSingleProduct(1L).get()).isEqualTo(product1);
    }
    
    
//    ----------------
    
    @Test
    void testUpdateProductPrice() {
        doNothing().when(productRepository).updatePrice(anyDouble(), anyLong());
        productService.updatePrice(50.0, 1L);
        verify(productRepository, times(1)).updatePrice(50.0, 1L);
    }
    
    @Test
    void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(1L);
        productService.deleteProduct(1L);
        verify(productRepository, times(1)).deleteById(1L); 
    }



}
