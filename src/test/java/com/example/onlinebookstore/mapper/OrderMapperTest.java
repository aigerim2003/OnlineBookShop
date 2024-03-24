package com.example.onlinebookstore.mapper;

import com.example.onlinebookstore.dto.OrderDTO;
import com.example.onlinebookstore.entities.Order;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderMapperTest {

    private final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    @Test
    public void testToDTO() {
        Order order = new Order();
        order.setId(1L);
        order.setUserId(101L);

        OrderDTO dto = orderMapper.toDTO(order);

        assertEquals(order.getId(), dto.getId());
        assertEquals(order.getUserId(), dto.getUserId());
    }

    @Test
    public void testToEntity() {
        OrderDTO dto = new OrderDTO();
        dto.setId(1L);
        dto.setUserId(101L);

        Order order = orderMapper.toEntity(dto);

        assertEquals(dto.getId(), order.getId());
        assertEquals(dto.getUserId(), order.getUserId());
    }
}
