package com.practice.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

}
