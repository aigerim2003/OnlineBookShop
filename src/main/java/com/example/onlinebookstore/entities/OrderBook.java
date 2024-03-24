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

    public Long getOrderId() {
        if (order != null) {
            return order.getId();
        }
        return null;
    }

    public Long getBookId() {
        if (book != null) {
            return book.getId();
        }
        return null;
    }

    public void setOrderId(Long orderId) {
    }

    public void setBookId(Long bookId) {
    }
}
