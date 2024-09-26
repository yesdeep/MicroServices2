package com.practice.demo.controller;

import java.awt.print.Book;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;


@RestController
@RequestMapping("/notify")
public class NotificationController {

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String sendNotification(@RequestBody Book book) {
        // For simplicity, just log the notification
        System.out.println("Notification: New book added");
        return "Notification sent";
    }
}
