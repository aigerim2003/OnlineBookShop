package com.example.onlinebookstore.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.example.onlinebookstore.entities.OrderBook;
import com.example.onlinebookstore.services.OrderBookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;

@WebMvcTest(OrderBookController.class)
@ExtendWith(MockitoExtension.class)
public class OrderBookRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private OrderBookService orderBookService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetOrderBookById() throws Exception {
        // Create a mock OrderBook object
        OrderBook orderBook = new OrderBook();
        orderBook.setId(1L);
        // Set other properties of orderBook as needed for testing

        // Mock the behavior of orderBookService.getOrderBookById to return Optional<OrderBook>
        when(orderBookService.getOrderBookById(1L)).thenReturn(Optional.of(orderBook));

        // Perform the GET request and verify the response
        mockMvc.perform(get("/api/order-books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1))); // Add other assertions for properties as needed
    }
}
