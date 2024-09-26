package com.practice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.practice.demo.model.Hospital;

@SpringBootApplication
public class LombokApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LombokApplication.class, args);

        Hospital hospital = new Hospital();
        hospital.setName("Apollo");
        hospital.setId(121L); 

        System.out.println(hospital);
    }
}
