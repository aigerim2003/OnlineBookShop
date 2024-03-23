package com.example.onlinebookstore;

import com.example.onlinebookstore.entities.Book;
import com.example.onlinebookstore.entities.User;
import com.example.onlinebookstore.repositories.BookRepository;
import com.example.onlinebookstore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUsers();
        loadBooks();
    }

    private void loadUsers() {
        try (InputStream inputStream = getClass().getResourceAsStream("/users.csv");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                User user = new User();
                user.setName(data[0]);
                user.setEmail(data[1]);
                userRepository.save(user); // Hibernate сам сгенерирует идентификатор
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void loadBooks() {
        try (InputStream inputStream = getClass().getResourceAsStream("/books.csv")) {
            if (inputStream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    Book book = new Book();
                    book.setTitle(data[0]);
                    book.setAuthor(data[1]);
                    book.setGenre(data[2]);
                    book.setPrice(BigDecimal.valueOf(Double.parseDouble(data[3])));
                    bookRepository.save(book);
                }
                reader.close();
            } else {
                System.err.println("Error: books.csv file not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
