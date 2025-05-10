/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import com.example.dto.FoodRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api")
public class FoodLoggerController {

    private Map<String, FoodRequest> foodRequest = new HashMap<>();

    @GetMapping("/get/food")
    public List<FoodRequest> ListFood() {
        return new ArrayList<>(foodRequest.values());
    }

    @PostMapping("/post/food")
    public FoodRequest add(@RequestBody FoodRequest request) {
        FoodRequest existing = foodRequest.get(request.getName());
        if (existing != null) {
            existing.setAmount(existing.getAmount() + request.getAmount());
        } else {
            foodRequest.put(request.getName(), new FoodRequest(request.getName(), request.getAmount()));
        }
        return foodRequest.get(request.getName());
    }
}
