/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import com.example.models.Philanthropy;
import com.example.models.PhilanthropyDetail;
import com.example.models.User;
import com.example.service.PhilanthropyDetailService;
import com.example.service.PhilanthropyService;
import com.example.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/philanthropy-details")
public class PhilanthropyDetailController {

    @Autowired
    private PhilanthropyDetailService service;

    @Autowired
    private PhilanthropyService philanthropyService;

    @Autowired
    private UserService userService;

//    @PostMapping()
//    public PhilanthropyDetail createDetail(
//            @RequestParam String name,
//            @RequestParam Integer philanthropyId,
//            @RequestParam String amount,
//            @RequestParam String type,
//            @RequestParam String description
//    ) {
//        User user = userService.getUserByName(name);
//        return service.createPhilanthropyDetail(user, philanthropyId, amount, type, description);
//    }
    @PostMapping()
    public PhilanthropyDetail createData(@RequestBody PhilanthropyDetail input) {
        // Safety: check that both user and philanthropy objects exist
        if (input.getUser() == null || input.getUser().getUserId() == null) {
            return null;
        }

        if (input.getPhilanthropy() == null || input.getPhilanthropy().getId() == null) {
            return null;
        }

        // Fetch managed entities
        User user = userService.getUserById(input.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Philanthropy philanthropy = philanthropyService.getPhilanthropyById(input.getPhilanthropy().getId())
                .orElseThrow(() -> new RuntimeException("Philanthropy not found"));

        // Set real entities to input
        input.setUser(user);
        input.setPhilanthropy(philanthropy);

        // Validate required fields
        if (input.getAmount() == null || input.getAmount().isBlank()) {
            return null;
        }
        return service.createPhilanthropyDetail(input);
    }

    @PutMapping("/{id}")
    public PhilanthropyDetail updateDetail(
            @PathVariable Integer id,
            @RequestParam String name,
            @RequestParam Integer philanthropyId,
            @RequestParam String amount,
            @RequestParam String type,
            @RequestParam String description
    ) {
        User user = userService.getUserByName(name);
        return service.updatePhilanthropyDetail(id, user, philanthropyId, amount, type, description);
    }
}
