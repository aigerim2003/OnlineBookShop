package com.example.onlinebookstore.services;
import com.example.onlinebookstore.dto.BookDTO;
import com.example.onlinebookstore.entities.Book;
import com.example.onlinebookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(BookDTO bookDto) {
        Book book = mapBookDtoToEntity(bookDto);
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private Book mapBookDtoToEntity(BookDTO bookDto) {
        Book book = new Book();
        // Map properties from bookDto to book
        book.setId(bookDto.getId());
        // Set other properties as needed
        return book;
    }
}
