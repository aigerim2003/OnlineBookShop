package com.example.onlinebookstore.controllers;

import com.example.onlinebookstore.dto.BookDTO;
import com.example.onlinebookstore.entities.Book;
import com.example.onlinebookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// BookController.java
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{bookId}")
    public ResponseEntity<Optional<Book>> getBook(@PathVariable Long bookId) {
        Optional<Book> bookDTO = bookService.getBookById(bookId);
        return ResponseEntity.ok(bookDTO);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO) {
        Book createdBookDTO = bookService.createBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBookDTO);
    }

    // Другие методы для обработки операций PUT, PATCH, DELETE
}
