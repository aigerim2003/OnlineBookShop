package com.example.onlinebookstore.dto;

import lombok.Data;

@Data
public class OrderBookDTO {
    private Long id;
    private Long orderId;
    private Long bookId;

    // Constructors
    public OrderBookDTO() {}

    public OrderBookDTO(Long id, Long orderId, Long bookId) {
        this.id = id;
        this.orderId = orderId;
        this.bookId = bookId;
    }
}
