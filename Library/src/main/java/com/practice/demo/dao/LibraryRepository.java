package com.practice.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.model.Library;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Integer>{
	
}
