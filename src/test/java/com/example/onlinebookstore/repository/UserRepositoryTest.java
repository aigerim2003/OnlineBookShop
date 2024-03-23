package com.example.onlinebookstore.repository;
import com.example.onlinebookstore.entities.User;
import com.example.onlinebookstore.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByName_thenReturnUser() {
        // Given
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        entityManager.persist(user);
        entityManager.flush();

        // When
        User found = userRepository.findByName(user.getName());

        // Then
        assertThat(found.getName()).isEqualTo(user.getName());
    }
}
