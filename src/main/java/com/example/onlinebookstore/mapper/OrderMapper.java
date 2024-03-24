package com.example.onlinebookstore.mapper;

// OrderMapper.java
import com.example.onlinebookstore.dto.OrderDTO;
import com.example.onlinebookstore.entities.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUserId());
        return dto;
    }

    public Order toEntity(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setUserId(dto.getUserId());
        return order;
    }
}
