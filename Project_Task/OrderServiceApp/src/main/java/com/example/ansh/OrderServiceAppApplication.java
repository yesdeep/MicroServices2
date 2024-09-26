package com.example.ansh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableFeignClients
@EnableCircuitBreaker
public class OrderServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceAppApplication.class, args);
	}

	/*@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}*/

}
