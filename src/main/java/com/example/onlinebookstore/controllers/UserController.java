package com.example.onlinebookstore.controllers;

import com.example.onlinebookstore.dto.UserDTO;
import com.example.onlinebookstore.entities.User;
import com.example.onlinebookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// UserController.java
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long userId) {
        Optional<User> userDTO = userService.getUserById(userId);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User createdUserDTO = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDTO);
    }

    // Другие методы для обработки операций PUT, PATCH, DELETE
}

