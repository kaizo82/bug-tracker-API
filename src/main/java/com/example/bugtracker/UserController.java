package com.example.bugtracker;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    // We inject the UserRepository directly here for simplicity
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Endpoint to create a new user
    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    // Endpoint to view all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}