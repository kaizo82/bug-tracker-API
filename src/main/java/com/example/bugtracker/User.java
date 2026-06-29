package com.example.bugtracker;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users") // "user" is often a reserved keyword in SQL, so we name the table "users"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    private String username;

    @Email(message = "Must be a valid email address")
    @NotBlank(message = "Email is required")
    private String email;


    public User() {}


    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}