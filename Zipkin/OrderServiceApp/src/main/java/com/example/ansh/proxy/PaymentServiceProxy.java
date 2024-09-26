package com.example.ansh.proxy;

import com.example.ansh.beans.Payment;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "payment-service")
@RibbonClient(name = "payment-service")
public interface PaymentServiceProxy {
    @GetMapping("payment/{paymentId}")
    Payment getPaymentDetail(@PathVariable("paymentId") String productId);
}
