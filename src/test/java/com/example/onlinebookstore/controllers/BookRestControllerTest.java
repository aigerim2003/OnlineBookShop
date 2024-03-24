package com.example.onlinebookstore.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.onlinebookstore.dto.BookDTO;
import com.example.onlinebookstore.entities.Book;
import com.example.onlinebookstore.services.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;

@WebMvcTest(BookController.class)
@ExtendWith(MockitoExtension.class)
public class BookRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetBookById() throws Exception {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Sample Book");
        book.setAuthor("Sample Author");
        book.setGenre("Sample Genre");
        book.setPrice(BigDecimal.valueOf(19.99));

        when(bookService.getBookById(1L)).thenReturn(Optional.of(book));

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Sample Book")))
                .andExpect(jsonPath("$.author", is("Sample Author")))
                .andExpect(jsonPath("$.genre", is("Sample Genre")))
                .andExpect(jsonPath("$.price", is(19.99)));
    }

    @Test
    public void testCreateBook() throws Exception {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("New Book");
        bookDTO.setAuthor("New Author");
        bookDTO.setGenre("New Genre");
        bookDTO.setPrice(BigDecimal.valueOf(24.99));

        mockMvc.perform(post("/api/books")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(bookDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateBook() throws Exception {
        BookDTO updatedBookDTO = new BookDTO();
        updatedBookDTO.setId(1L);
        updatedBookDTO.setTitle("Updated Book");
        updatedBookDTO.setAuthor("Updated Author");
        updatedBookDTO.setGenre("Updated Genre");
        updatedBookDTO.setPrice(BigDecimal.valueOf(29.99));

        mockMvc.perform(put("/api/books/1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(updatedBookDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/api/books/1"))
                .andExpect(status().isOk());
    }
}
