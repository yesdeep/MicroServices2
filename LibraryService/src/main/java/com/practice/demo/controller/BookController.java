package com.practice.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.model.Book;
import com.practice.demo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
    private BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
  
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
       
        return bookService.getAllBooks();
    }
}
