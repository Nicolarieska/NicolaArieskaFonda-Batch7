/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import com.example.models.User;
import com.example.service.UserResponseService;
import com.example.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserResponseService service;

    @GetMapping()
    public List<User> getAllUser() {
        List<User> user = this.service.getAllUsers();
        return user;
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return this.service.getUserById(id);
    }

    @PostMapping()
    public User createUser(@RequestBody User body) {
        return this.service.createUser(body);
    }

    @PutMapping("/{id}")
    public User updateByUserId(@PathVariable Long id, @RequestBody User body) {
        body.setId(id);
        return this.service.updateByUserId(id, body);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        this.service.deleteUserById(id);
        return "User Deleted";
    }
}
