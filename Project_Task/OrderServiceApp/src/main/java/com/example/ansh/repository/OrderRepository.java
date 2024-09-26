package com.example.ansh.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ansh.beans.Orders;
public interface OrderRepository extends CrudRepository<Orders, String> {

}
