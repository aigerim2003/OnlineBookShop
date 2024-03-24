package com.example.onlinebookstore.mapper;

import com.example.onlinebookstore.dto.BookDTO;
import com.example.onlinebookstore.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

@DataJpaTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testToDTO() {
        // Given
        Book book = new Book();
        book.setId(1L);
        book.setTitle("To Kill a Mockingbird");
        book.setAuthor("Harper Lee");
        book.setGenre("Fiction");
        book.setPrice(BigDecimal.valueOf(12.99));

        // When
        BookDTO dto = bookMapper.toDTO(book);

        // Then
        assertThat(dto.getId()).isEqualTo(book.getId());
        assertThat(dto.getTitle()).isEqualTo(book.getTitle());
        assertThat(dto.getAuthor()).isEqualTo(book.getAuthor());
        assertThat(dto.getGenre()).isEqualTo(book.getGenre());
        assertThat(dto.getPrice()).isEqualTo(book.getPrice());
    }

    @Test
    public void testToEntity() {
        // Given
        BookDTO dto = new BookDTO();
        dto.setId(1L);
        dto.setTitle("To Kill a Mockingbird");
        dto.setAuthor("Harper Lee");
        dto.setGenre("Fiction");
        dto.setPrice(BigDecimal.valueOf(12.99));

        // When
        Book book = bookMapper.toEntity(dto);

        // Then
        assertThat(book.getId()).isEqualTo(dto.getId());
        assertThat(book.getTitle()).isEqualTo(dto.getTitle());
        assertThat(book.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(book.getGenre()).isEqualTo(dto.getGenre());
        assertThat(book.getPrice()).isEqualTo(dto.getPrice());
    }
}
