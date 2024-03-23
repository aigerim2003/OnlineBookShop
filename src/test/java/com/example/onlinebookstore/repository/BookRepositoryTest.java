package com.example.onlinebookstore.repository;
import com.example.onlinebookstore.entities.Book;
import com.example.onlinebookstore.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void whenFindByTitle_thenReturnBook() {
        // Given
        Book book = new Book();
        book.setTitle("To Kill a Mockingbird");
        book.setAuthor("Harper Lee");
        book.setGenre("Fiction");
        book.setPrice(BigDecimal.valueOf(12.99));
        entityManager.persist(book);
        entityManager.flush();

        // When
        Book found = bookRepository.findByTitle(book.getTitle());

        // Then
        assertThat(found.getTitle()).isEqualTo(book.getTitle());
    }
}
