package com.example.onlinebookstore.mapper;

import com.example.onlinebookstore.dto.BookDTO;
import com.example.onlinebookstore.entities.Book;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

import java.math.BigDecimal;

@Component
public class BookMapper {

    public BookDTO toDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setGenre(book.getGenre());
        dto.setPrice(BigDecimal.valueOf(book.getPrice()));
        return dto;
    }

    public Book toEntity(BookDTO dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setGenre(dto.getGenre());
        book.setPrice(dto.getPrice());
        return book;
    }
}
