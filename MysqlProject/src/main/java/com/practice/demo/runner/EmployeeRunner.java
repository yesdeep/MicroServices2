package com.practice.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.demo.dao.EmployeeRepository;
import com.practice.demo.model.Employee;

@Component
public class EmployeeRunner implements CommandLineRunner {
    @Autowired
    EmployeeRepository repo;

    @Override
    public void run(String... args) throws Exception {
        repo.save(new Employee(-10, "John", 100));
        repo.save(new Employee(-9, "Alice", 200));
        repo.save(new Employee(-8, "Bob", 300));
        repo.save(new Employee(-7, "Charlie", 400));
        repo.save(new Employee(-6, "David", 500));
        repo.save(new Employee(-5, "Emma", 600));
        repo.save(new Employee(-4, "Frank", 700));
        repo.save(new Employee(-3, "Grace", 800));
        repo.save(new Employee(-2, "Hannah", 900));
        repo.save(new Employee(-1, "Ivy", 1000));
        repo.save(new Employee(0, "Jack", 1100));
        System.out.println("runner");
    }
}

