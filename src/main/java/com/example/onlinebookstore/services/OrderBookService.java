package com.example.onlinebookstore.services;

import com.example.onlinebookstore.dto.OrderBookDTO;
import com.example.onlinebookstore.entities.OrderBook;
import com.example.onlinebookstore.repositories.OrderBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderBookService {

    @Autowired
    private OrderBookRepository orderBookRepository;

    public List<OrderBook> getAllOrderBooks() {
        return orderBookRepository.findAll();
    }

    public Optional<OrderBook> getOrderBookById(Long id) {
        return orderBookRepository.findById(id);
    }

    public OrderBook createOrderBook(OrderBookDTO orderBookDto) {
        OrderBook orderBook = mapOrderBookDtoToEntity(orderBookDto);
        return orderBookRepository.save(orderBook);
    }

    public OrderBook updateOrderBook(OrderBook orderBook) {
        return orderBookRepository.save(orderBook);
    }

    public void deleteOrderBook(Long id) {
        orderBookRepository.deleteById(id);
    }

    private OrderBook mapOrderBookDtoToEntity(OrderBookDTO orderBookDto) {
        OrderBook orderBook = new OrderBook();
        // Mapping properties from orderBookDto to orderBook
        orderBook.setOrderId(orderBookDto.getOrderId());
        orderBook.setBookId(orderBookDto.getBookId());
        // Set other properties as needed
        return orderBook;
    }
}
