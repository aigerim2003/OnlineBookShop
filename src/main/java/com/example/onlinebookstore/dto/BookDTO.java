package com.example.onlinebookstore.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private BigDecimal price;

    // Getters and setters
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
