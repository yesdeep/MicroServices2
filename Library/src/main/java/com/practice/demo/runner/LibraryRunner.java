package com.practice.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.demo.model.Library;
import com.practice.demo.service.LibraryService;

@Component
public class LibraryRunner implements CommandLineRunner{

	@Autowired
	LibraryService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		service.addBook(new Library(1, "To Kill a Mockingbird"));
		service.addBook(new Library(2, "1984"));
		service.addBook(new Library(3, "Pride and Prejudice"));
		service.addBook(new Library(4, "The Great Gatsby"));
		service.addBook(new Library(5, "Moby-Dick"));
		service.addBook(new Library(6, "War and Peace"));
		service.addBook(new Library(7, "The Catcher in the Rye"));
		service.addBook(new Library(8, "The Hobbit"));
		service.addBook(new Library(9, "Brave New World"));
		service.addBook(new Library(10, "The Lord of the Rings"));
		
		System.out.println("Runner");
		
	}
	
}
