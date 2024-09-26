package com.example.ansh.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
 
import com.example.ansh.beans.Product;

@FeignClient(name = "product-service")
@RibbonClient(name = "product-service")  // load balancer
public interface ProductServiceProxy {
    @GetMapping("product/{productId}")
    Product getProductDetail(@PathVariable("productId") String productId);
}
