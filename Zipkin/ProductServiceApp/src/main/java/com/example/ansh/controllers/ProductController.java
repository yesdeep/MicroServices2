package com.example.ansh.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ansh.beans.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/product")
@Api(value="onlinestore", description = "Operations pertaining to products in Online Store")
public class ProductController {

    @ApiOperation(value = "View a list of available products", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProductDetail(@PathVariable String productId) {
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName("Laptop");
        product.setProductPrice("10000");
        return product;
    }

    @ApiOperation(value = "Creating products", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Product Created Successfully "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping
    public Product createProductDetail(Product product) {
        return product;
    }

}

