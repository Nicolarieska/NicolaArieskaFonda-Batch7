/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;

import com.example.models.User;
import com.example.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class UserResponseService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return this.repository.findById(id);
    }

    public User createUser(User body) {
        body.setPassword(passwordEncoder.encode(body.getPassword()));
        return this.repository.save(body);
    }

    public String deleteUserById(Long id) {
        this.repository.deleteById(id);
        return "User Deleted";
    }

    public User updateByUserId(Long id, User body) {
        Optional<User> existingUserOpt = repository.findById(id);
        if (existingUserOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User existingUser = existingUserOpt.get();

        existingUser.setUsername(body.getUsername());

        if (body.getPassword() != null && !body.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(body.getPassword()));
        }

        return this.repository.save(existingUser);
    }
}
