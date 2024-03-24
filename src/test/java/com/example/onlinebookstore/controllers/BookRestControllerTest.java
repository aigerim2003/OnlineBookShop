package com.example.onlinebookstore.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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

        // Mocking the behavior of bookService.getBookById to return Optional<Book>
        when(bookService.getBookById(1L)).thenReturn(Optional.of(book));

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Sample Book")))
                .andExpect(jsonPath("$.author", is("Sample Author")))
                .andExpect(jsonPath("$.genre", is("Sample Genre")))
                .andExpect(jsonPath("$.price", is(19.99)));
    }

    // Other test methods
}
