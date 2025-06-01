/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import com.example.dto.LoginRequest;
import com.example.dto.AuthResponse;
import com.example.dto.RegisterRequest;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.example.utils.JwtUtil;
import com.example.models.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authMgr;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService uds;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> auth(@RequestBody LoginRequest dto) {
        authMgr.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(), dto.getPassword()
                )
        );

        UserDetails ud = uds.loadUserByUsername(dto.getUsername());
        String token = jwtUtil.generateToken(ud);

        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public Map<String, Object> registerUser(@RequestBody RegisterRequest req) {
        if (userRepository.findByUsername(req.getUsername()).isPresent()) {
            throw new RuntimeException("Username (email) is already registered.");
        }

        User user = new User();
        user.setName(req.getName());
        user.setAge(req.getAge());
        user.setUsername(req.getUsername());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        userRepository.save(user);

        UserDetails userDetails = uds.loadUserByUsername(user.getUsername());

        String token = jwtUtil.generateToken(userDetails);

        Map<String, Object> res = new HashMap<>();
        res.put("message", "User Registered & Logged in Successfully.");
        res.put("token", token);
        return res;
    }
}
