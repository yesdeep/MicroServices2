package com.example.ansh.service;

import com.example.ansh.beans.Payment;
import com.example.ansh.proxy.PaymentServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.ansh.beans.Orders;
import com.example.ansh.beans.Product;
import com.example.ansh.beans.Responses;
import com.example.ansh.proxy.ProductServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

	@Autowired
	ProductServiceProxy productServiceProxy;

	@Autowired
	PaymentServiceProxy paymentServiceProxy;

	@HystrixCommand(fallbackMethod = "getOrderDetailFallBack")
	public Responses getOrderDetail(String orderId) {
		Responses response = new Responses();

		Orders order = new Orders();
		order.setOrderId(orderId);
		order.setOrderQty("10");
		order.setProductId("P1001");
		order.setProduct(getProductDetail(order.getProductId()));
		order.setPaymentId("PY101");
		order.setPayment(getPaymentDetail(order.getPaymentId()));

		response.setData(order);
		response.setStatus("200");
		response.setMsg("SUCCESS");
		return response;
	}

	private Payment getPaymentDetail(String paymentId) {
		Payment payment = paymentServiceProxy.getPaymentDetail(paymentId);
		return payment;
	}

	private Product getProductDetail(String productId) {
		Product product = productServiceProxy.getProductDetail(productId);
		return product;
	}

	public Responses getOrderDetailFallBack(String orderId, Throwable ex) {
		Responses response = new Responses();
		response.setStatus("404");
		response.setMsg("Failure");
		response.setData(ex.getCause());
		return response;
	}

	/*String URL = "http://product-service/product/";
	@Autowired
	private RestTemplate restTemplate;
	public Responses getOrderDetail(String orderId) {
		Responses response = new Responses();
		Orders order = new Orders();
		order.setOrderId(orderId);
		order.setOrderQty("10");
		order.setProductId("P1001");
		order.setProduct(getProductDetail(order.getProductId()));

		response.setData(order);
		response.setMsg("SUCCESS");
		response.setStatus("200");
		return response;
	}

	private Product getProductDetail(String productId) {
		Product product = restTemplate.getForObject(URL+productId, Product.class);
		return product;
	}*/
}
