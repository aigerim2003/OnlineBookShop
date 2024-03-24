package com.example.onlinebookstore.controllers;

import com.example.onlinebookstore.dto.OrderDTO;
import com.example.onlinebookstore.entities.Order;
import com.example.onlinebookstore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// OrderController.java
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{orderId}")
    public ResponseEntity<Optional<Order>> getOrder(@PathVariable Long orderId) {
        Optional<Order> orderDTO = orderService.getOrderById(orderId);
        return ResponseEntity.ok(orderDTO);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        Order createdOrderDTO = orderService.createOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderDTO);
    }

    // Другие методы для обработки операций PUT, PATCH, DELETE
}

