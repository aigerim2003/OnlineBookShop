package com.example.onlinebookstore.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.example.onlinebookstore.dto.OrderDTO;
import com.example.onlinebookstore.services.OrderService;
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

@WebMvcTest(OrderController.class)
@ExtendWith(MockitoExtension.class)
public class OrderRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetOrderById() throws Exception {
        // Create a mock Order object
        com.example.onlinebookstore.entities.Order order = new com.example.onlinebookstore.entities.Order();
        order.setId(1L);
        // Set other properties of order as needed for testing

        // Mock the behavior of orderService.getOrderById to return Optional<Order>
        when(orderService.getOrderById(1L)).thenReturn(Optional.of(order));

        // Perform the GET request and verify the response
        mockMvc.perform(get("/api/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1))); // Add other assertions for properties as needed
    }
}
