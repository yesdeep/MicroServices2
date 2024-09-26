package com.example.ansh.controllers;

import com.example.ansh.beans.Payment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/payment")
@Api(value="onlinestore", description = "Operations in payment Online Store")
public class PaymentController {

    @ApiOperation(value = "View a list of available products", response = Payment.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Payment Successful"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/{paymentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Payment getPaymentDetail(@PathVariable String paymentId) {
        Payment payment = new Payment();
        payment.setPaymentId(paymentId);
        payment.setPaymentMode("Credit Card");
        payment.setPaymentStatus(true);
        return payment;
    }

    @ApiOperation(value = "Creating payment", response = Payment.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Product Created Successfully "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping
    public Payment createProductDetail(Payment payment) {
        return payment;
    }

}

