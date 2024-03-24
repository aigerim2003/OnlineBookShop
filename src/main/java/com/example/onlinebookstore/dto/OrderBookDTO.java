package com.example.onlinebookstore.dto;

import lombok.Data;

@Data
public class OrderBookDTO {
    private Long id;
    private Long orderId;
    private Long bookId;

    // Constructor, getters, and setters
    // Constructors
    public OrderBookDTO() {}

    public OrderBookDTO(Long id, Long orderId, Long bookId) {
        this.id = id;
        this.orderId = orderId;
        this.bookId = bookId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
