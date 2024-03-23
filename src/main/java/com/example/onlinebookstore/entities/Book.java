package com.example.onlinebookstore.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String genre;
    private double price;

    public void setPrice(BigDecimal bigDecimal) {
    }

    // Constructor(s), getters and setters, and any additional methods
}