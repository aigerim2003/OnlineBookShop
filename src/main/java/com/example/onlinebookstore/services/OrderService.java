package com.example.onlinebookstore.services;

import com.example.onlinebookstore.dto.OrderDTO;
import com.example.onlinebookstore.entities.Order;
import com.example.onlinebookstore.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(OrderDTO orderDto) {
        Order order = mapOrderDtoToEntity(orderDto);
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    private Order mapOrderDtoToEntity(OrderDTO orderDto) {
        Order order = new Order();
        // Map properties from orderDto to order
        order.setId(orderDto.getId());
        // Set other properties as needed
        return order;
    }
}
