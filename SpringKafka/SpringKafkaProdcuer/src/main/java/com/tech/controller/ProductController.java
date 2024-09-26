package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.Product;
import com.tech.service.KafkaSender;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private KafkaSender kafkaSender;

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        kafkaSender.sendMessage(product);
        return "Product Creation is in process...";
    }

}
