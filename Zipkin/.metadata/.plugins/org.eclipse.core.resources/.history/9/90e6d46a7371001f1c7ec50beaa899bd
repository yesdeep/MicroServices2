package com.info.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.beans.Response;

@RestController
@RequestMapping("/fallback")
public class APIGatewayController {

    @GetMapping("/productservice")
    public Response getFallBackProductService() {
        Response response = new Response();
        response.setDt(new Date());
        response.setMessage("Product Service is down...");
        return response;
    }

    @GetMapping("/orderservice")
    public Response getFallBackOrderService() {
        Response response = new Response();
        response.setDt(new Date());
        response.setMessage("Order Service is down...");
        return response;
    }

    @GetMapping("/paymenttservice")
    public Response getFallBackPaymentService() {
        Response response = new Response();
        response.setDt(new Date());
        response.setMessage("Payment Service is down...");
        return response;
    }

    @GetMapping("/defaultservice")
    public Response getFallBackDefaultService() {
        Response response = new Response();
        response.setDt(new Date());
        response.setMessage("Service is unavailable...");
        return response;
    }
}