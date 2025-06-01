/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import com.example.models.User;
import com.example.service.UserResponseService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
@RequestMapping("/api/me")
public class UserController {

    @Autowired
    private UserResponseService service;

    @GetMapping()
    public ResponseEntity<User> getProfile() {
        User user = service.getUser();
        return ResponseEntity.ok(user);
    }

    @PatchMapping()
    public ResponseEntity<User> patchProfile(@RequestBody User body) {
        User userUpdate = service.patchUser(body);
        return ResponseEntity.ok(userUpdate);
    }
}
