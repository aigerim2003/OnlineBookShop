package com.example.onlinebookstore.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.onlinebookstore.dto.OrderDTO;
import com.example.onlinebookstore.entities.Order;
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

    @Test
    public void testCreateOrder() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        // Set properties of orderDTO as needed for testing

        mockMvc.perform(post("/api/orders")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(orderDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateOrder() throws Exception {
        OrderDTO updatedOrderDTO = new OrderDTO();
        updatedOrderDTO.setId(1L);
        // Set other properties of updatedOrderDTO as needed for testing

        mockMvc.perform(put("/api/orders/1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(updatedOrderDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteOrder() throws Exception {
        mockMvc.perform(delete("/api/orders/1"))
                .andExpect(status().isOk());
    }
}
