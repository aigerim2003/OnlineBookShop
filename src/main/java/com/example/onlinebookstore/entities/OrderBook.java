package com.example.onlinebookstore.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_book")
public class OrderBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Object get() {
        // Method body
        return null; // Replace null with the actual data to return
    }

    public boolean getOrderId() {
        // Method body
        // Return true or false based on some condition
        return  true;
    }

    public boolean getBookId() {
        // Method body
        // Return true or false based on some condition
        return  true;
    }

    // Constructors, getters and setters, and any additional methods
}

