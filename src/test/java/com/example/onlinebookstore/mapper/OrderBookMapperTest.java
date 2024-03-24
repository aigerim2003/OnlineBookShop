package com.example.onlinebookstore.mapper;

// OrderBookMapperTest.java
import com.example.onlinebookstore.dto.OrderBookDTO;
import com.example.onlinebookstore.entities.OrderBook;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderBookMapperTest {

    private final OrderBookMapper orderBookMapper = Mappers.getMapper(OrderBookMapper.class);

    @Test
    public void testToDTO() {
        OrderBook orderBook = new OrderBook();
        orderBook.setOrderId(1L);
        orderBook.setBookId(101L);

        OrderBookDTO dto = orderBookMapper.toDTO(orderBook);

        assertEquals(orderBook.getOrderId(), dto.getOrderId());
        assertEquals(orderBook.getBookId(), dto.getBookId());
    }

    @Test
    public void testToEntity() {
        OrderBookDTO dto = new OrderBookDTO();
        dto.setOrderId(1L);
        dto.setBookId(101L);

        OrderBook orderBook = orderBookMapper.toEntity(dto);

        assertEquals(dto.getOrderId(), orderBook.getOrderId());
        assertEquals(dto.getBookId(), orderBook.getBookId());
    }
}
