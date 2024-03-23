package com.example.onlinebookstore.repository;

import com.example.onlinebookstore.entities.OrderBook;
import com.example.onlinebookstore.repositories.OrderBookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OrderBookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderBookRepository orderBookRepository;

    @Test
    public void whenFindByOrder_IdAndBook_Id_thenReturnOrderBook() {
        // Given
        OrderBook orderBook = new OrderBook();
        entityManager.persist(orderBook);
        entityManager.flush();

        // When
        OrderBook found = (OrderBook) orderBookRepository.findById(orderBook.getOrderId(), orderBook.getBookId()).orElse(null);

        // Then
        assertThat(found).isNotNull();
        assertThat(found.getOrderId()).isEqualTo(orderBook.getOrderId());
        assertThat(found.getBookId()).isEqualTo(orderBook.getBookId());
    }
}
