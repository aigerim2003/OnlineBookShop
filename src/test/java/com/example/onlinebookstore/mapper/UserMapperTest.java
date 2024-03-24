package com.example.onlinebookstore.mapper;

import com.example.onlinebookstore.dto.UserDTO;
import com.example.onlinebookstore.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testToDTO() {
        // Create a User entity
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");

        // Map entity to DTO
        UserDTO dto = userMapper.toDTO(user);

        // Assertions
        assertThat(dto.getName()).isEqualTo(user.getName());
        assertThat(dto.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testToEntity() {
        // Create a UserDTO
        UserDTO dto = new UserDTO();
        dto.setName("John Doe");
        dto.setEmail("john@example.com");

        // Map DTO to entity
        User user = userMapper.toEntity(dto);

        // Assertions
        assertThat(user.getName()).isEqualTo(dto.getName());
        assertThat(user.getEmail()).isEqualTo(dto.getEmail());
    }
}

