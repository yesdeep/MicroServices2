package com.crud.demo.model;

import javax.persistence.*;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productId;
	
	private String productName;
	
	private double productPrice;
	
	private int quantity;

	public Product() {}

	public Product(Long productId, String productName, double productPrice, int quantity) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double price) {
		this.productPrice = price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}
	
	
}

