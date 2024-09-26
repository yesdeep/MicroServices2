package com.crud.demo.controller;

import java.util.*;

import com.crud.demo.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.crud.demo.model.Product;
import com.crud.demo.model.UpdateProductPrice;
import com.crud.demo.service.ProductService;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("v1")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/welcome")
	public ModelAndView welcomePage() {
		return new ModelAndView("welcome");
	}
	
	@PostMapping("/product/new")
	public ResponseEntity createProduct(@RequestBody Product product) {
		Product newProduct = productService.createProduct(product);
		return ResponseEntity.ok("Created new product " + newProduct);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id) {
		Optional<Product> product = productService.getSingleProduct(id);
		if (product.isPresent())
			return ResponseEntity.ok(product.get());
		throw new ProductNotFoundException(id);
	}
	
	@GetMapping("/product/all")
	public List<Product> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return products;
	}

	@GetMapping("/products")
	public ModelAndView getAllProductsView() {
		List<Product> products = productService.getAllProducts();
		ModelAndView modelAndView = new ModelAndView("allProducts");
		modelAndView.addObject("listOfProducts", products);
		return modelAndView;
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updatePrice(@PathVariable Long id, @RequestBody UpdateProductPrice updateProductPrice) {
		productService.updatePrice(updateProductPrice.getProductPrice(), id);
		return ResponseEntity.ok(productService.getSingleProduct(id).get());
	}
	
	@DeleteMapping("product/{id}")
	public ResponseEntity deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok("Deleted product");
	}

	@PostMapping("/addProduct")
	public String submit(@ModelAttribute("product") Product product, Model model, BindingResult result) {
		if (result.hasErrors())
			return "error";
		model.addAttribute("name", product.getProductName());
		model.addAttribute("price", product.getProductPrice());
		return "productView";
	}

}
