package com.example.onlinebookstore.controllers;

import com.example.onlinebookstore.exception.GlobalExceptionHandler;
import com.example.onlinebookstore.exception.ResourceNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorControllerTest {

    private final GlobalExceptionHandler errorController = new GlobalExceptionHandler();

    @Test
    public void testHandleResourceNotFoundException() {
        // Создание исключения ResourceNotFoundException
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");

        // Вызов метода обработки ошибки с этим исключением
        ResponseEntity<String> response = errorController.handleResourceNotFoundException(exception);

        // Проверка статуса ответа
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
