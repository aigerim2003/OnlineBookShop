package com.example.onlinebookstore.mapper;

// OrderBookMapper.java
import com.example.onlinebookstore.dto.OrderBookDTO;
import com.example.onlinebookstore.entities.OrderBook;
import org.springframework.stereotype.Component;

@Component
public class OrderBookMapper {

    public OrderBookDTO toDTO(OrderBook orderBook) {
        OrderBookDTO dto = new OrderBookDTO();
        dto.setOrderId(orderBook.getOrderId());
        dto.setBookId(orderBook.getBookId());
        return dto;
    }

    public OrderBook toEntity(OrderBookDTO dto) {
        OrderBook orderBook = new OrderBook();
        orderBook.setOrderId(dto.getOrderId());
        orderBook.setBookId(dto.getBookId());
        return orderBook;
    }
}

