package com.practice.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.demo.dao.LibraryRepository;
import com.practice.demo.model.Library;

@Service
public class LibraryService {
	
	@Autowired
	LibraryRepository repo;
	
	public List<Library> getAllBooks() {
		return (List<Library>) repo.findAll();
	}
	
	public String addBook(Library book) {
		repo.save(book);
		return "Book with id " + book.getBookId() +" is added";
	}
	
	public String deleteBook(int id) {
		repo.deleteById(id);
		return "Book with id " + id +" is deleted";
	}
	
	public String editBook(Library book) {
		for(Library book2 : (List<Library>) repo.findAll()) {
			if(book2.getBookId()== book.getBookId()) {
				repo.deleteById(book.getBookId());
				repo.save(book);
				return "Book with id " + book.getBookId() +" is edited";
			}
		}
		return "Book with id " + book.getBookId() +" cannot be found";
	}
	
	
}
