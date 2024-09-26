package com.crud.demo.test.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.crud.demo.model.Product;
import com.crud.demo.model.UpdateProductPrice;
import com.crud.demo.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ProductController.class)
@SpringBootTest
@AutoConfigureMockMvc
class TestController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private Product product;

    private List<Product> productList;

    @BeforeEach
    void setUp() {
        product = new Product(1L, "Book", 15, 45);
    }

    @AfterEach
    void tearDown() {
        product = null;
    }

    @Test
    void testPostProduct() throws Exception {

        when(productService.createProduct(any())).thenReturn(product);
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/product/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(product)))
                .andExpect(status().isOk());
        verify(productService).createProduct(any());
    }

    @Test
    void testRetrieveAllProducts() throws Exception {
        Product product1 = new Product(2L, "Chair", 37, 25);
        productList = Arrays.asList(product, product1);
        when (productService.getAllProducts()).thenReturn(productList);
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/product/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
        verify(productService).getAllProducts();
    }

    @Test
    void retrieveProductById() throws Exception {
        when(productService.getSingleProduct(any())).thenReturn(Optional.of(product));
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/product/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
        verify(productService).getSingleProduct(any());


    }

    private String asJsonString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
//    --------------------------------------------
    
    
    
    @Test
    void testDeleteProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/product/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
        verify(productService).deleteProduct(1L);
    }

    
    @Test
    void testUpdateProductPrice() throws Exception {
        UpdateProductPrice updatePrice = new UpdateProductPrice();
        when(productService.getSingleProduct(any())).thenReturn(Optional.of(product));

        mockMvc.perform(MockMvcRequestBuilders.put("/v1/product/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(updatePrice)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

        verify(productService).updatePrice(updatePrice.getProductPrice(), 1L);
    }

    @Test
    void testGetAllProductsView() throws Exception {
        Product product1 = new Product(2L, "Chair", 37, 25);
        productList = Arrays.asList(product, product1);
        when(productService.getAllProducts()).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("allProducts"))
                .andExpect(model().attributeExists("listOfProducts"))
                .andDo(MockMvcResultHandlers.print());
    }

    
    
    
    
    
}
