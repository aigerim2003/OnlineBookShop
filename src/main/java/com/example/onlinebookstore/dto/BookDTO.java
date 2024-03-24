package com.example.onlinebookstore.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;


@Data
public class BookDTO {

    @NotNull
    private Long id;

    private String title;
    private String author;
    private String genre;
    private BigDecimal price;

    // Getters and setters
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
