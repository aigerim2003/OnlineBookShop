package com.example.onlinebookstore.controllers;

import com.example.onlinebookstore.dto.OrderBookDTO;
import com.example.onlinebookstore.entities.OrderBook;
import com.example.onlinebookstore.services.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// OrderBookController.java
@RestController
@RequestMapping("/api/orderBooks")
public class OrderBookController {

    @Autowired
    private OrderBookService orderBookService;

    @GetMapping("/{orderBookId}")
    public ResponseEntity<Optional<OrderBook>> getOrderBook(@PathVariable Long orderBookId) {
        Optional<OrderBook> orderBookDTO = orderBookService.getOrderBookById(orderBookId);
        return ResponseEntity.ok(orderBookDTO);
    }

    @PostMapping
    public ResponseEntity<OrderBook> createOrderBook(@RequestBody OrderBookDTO orderBookDTO) {
        OrderBook createdOrderBookDTO = orderBookService.createOrderBook(orderBookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderBookDTO);
    }

    // Другие методы для обработки операций PUT, PATCH, DELETE
}
