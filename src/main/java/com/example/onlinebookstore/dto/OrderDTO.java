package com.example.onlinebookstore.dto;
import lombok.Data;


public class OrderDTO {
    private Long id;
    private Long userId;

    public Long getId() {
        return id;
    }

    public OrderDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public OrderDTO setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}
