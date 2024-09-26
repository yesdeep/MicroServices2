package com.example.ansh.beans;

import io.swagger.annotations.ApiModelProperty;

public class Product {

	@ApiModelProperty("The database generated product ID")
	private String productId;
	@ApiModelProperty("The product description")
	private String productName;
	@ApiModelProperty("The product price")
	private String productPrice;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
