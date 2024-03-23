package com.example.onlinebookstore.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table (name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Book> books = new ArrayList<>();

    // Конструктор(ы) не требуется, так как Lombok сгенерирует его автоматически
}
