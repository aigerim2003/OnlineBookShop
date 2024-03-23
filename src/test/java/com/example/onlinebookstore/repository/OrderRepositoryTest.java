package com.example.onlinebookstore.repository;

import com.example.onlinebookstore.entities.Order;
import com.example.onlinebookstore.repositories.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void whenFindById_thenReturnOrder() {
        // Given
        Order order = new Order();
        entityManager.persist(order);
        entityManager.flush();

        // When
        Order found = orderRepository.findById(order.getId()).orElse(null);

        // Then
        assertThat(found.getId()).isEqualTo(order.getId());
    }
}

