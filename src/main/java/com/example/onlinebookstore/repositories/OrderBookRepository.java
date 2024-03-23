package com.example.onlinebookstore.repositories;

import com.example.onlinebookstore.entities.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {
    Optional<Object> findById(boolean orderId, boolean bookId);
}
