package com.practice.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.practice.demo.model.Book;
import com.practice.demo.repository.BookRepository;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
    private RestTemplate restTemplate;

	public Book addBook(Book book) {
        // Save the book to the database
        Book savedBook = bookRepository.save(book);

        // Prepare headers to set the content type as JSON
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create a new HttpEntity with the book and the headers
        HttpEntity<Book> request = new HttpEntity<>(savedBook, headers);

        // Send the notification with the correct headers
        restTemplate.postForObject("http://notification-service/notify", request, String.class);

        return savedBook;
    }
    public List<Book> getAllBooks() {
        
        return (List<Book>) bookRepository.findAll();
    }
	
	
}
