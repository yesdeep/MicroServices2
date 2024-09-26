package com.practice.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	
	@Query(value = "SELECT * FROM User WHERE name = :name", nativeQuery = true)
	public List<User> findUsersByName(@Param("name") String name);
}
