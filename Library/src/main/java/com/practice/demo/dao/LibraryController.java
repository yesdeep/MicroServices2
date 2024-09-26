package com.practice.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.model.Library;
import com.practice.demo.service.LibraryService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LibraryController {

	@Autowired
	LibraryService service;
	
	@GetMapping("/getall")
	public List<Library> getAllBooks() {
		return service.getAllBooks();
	}
	
	@PostMapping("/addbook")
	public void addBook(Library book) {
	    System.out.println("Received book to add: " + book); // Logging the incoming book
		service.addBook(new Library(13, "mani"));
	}
	
	@DeleteMapping("/deletebook/id")
	public void deleteBook(@PathVariable int id) {
		service.deleteBook(id);
	}
	
	@PutMapping("/editbook")
	public void updateBook(Library book) {
		service.editBook(book);
	}
	
}
