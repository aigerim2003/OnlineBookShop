package com.example.onlinebookstore.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Test
    public void testCreateOrderBook() throws Exception {
        // Create a mock OrderBook object
        OrderBook orderBook = new OrderBook();
        // Set properties of orderBook as needed for testing

        // Mock the behavior of orderBookService.createOrderBook to return the created orderBook
        when(orderBookService.createOrderBook(orderBook)).thenReturn(orderBook);

        // Perform the POST request and verify the response
        mockMvc.perform(post("/api/order-books")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(orderBook)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateOrderBook() throws Exception {
        // Create a mock OrderBook object
        OrderBook updatedOrderBook = new OrderBook();
        updatedOrderBook.setId(1L);
        // Set other properties of updatedOrderBook as needed for testing

        // Mock the behavior of orderBookService.updateOrderBook to return the updated orderBook
        when(orderBookService.updateOrderBook(updatedOrderBook)).thenReturn(updatedOrderBook);

        // Perform the PUT request and verify the response
        mockMvc.perform(put("/api/order-books/1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(updatedOrderBook)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteOrderBook() throws Exception {
        // Perform the DELETE request and verify the response
        mockMvc.perform(delete("/api/order-books/1"))
                .andExpect(status().isOk());
    }
}
