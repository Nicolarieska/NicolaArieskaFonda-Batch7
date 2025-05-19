/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import com.example.models.Philanthropy;
import com.example.service.PhilanthropyService;
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
@RequestMapping("/api/philanthropy")
public class PhilanthropyController {

    @Autowired
    private PhilanthropyService philanthropyService;

    @GetMapping()
    public List<Philanthropy> getAllPhilanthropy() {
        List<Philanthropy> philanthropy = this.philanthropyService.getAllPhilanthropies();
        return philanthropy;
    }

    @GetMapping("/{id}")
    public Optional<Philanthropy> getKruById(@PathVariable Integer id) {
        return this.philanthropyService.getPhilanthropyById(id);
    }

    @PostMapping()
    public Philanthropy createPhilanthropy(@RequestBody Philanthropy body) {
        return this.philanthropyService.createPhilanthropy(body);
    }

    @DeleteMapping("/{id}")
    public String deletePhilanthropyById(@PathVariable Integer id) {
        this.philanthropyService.deletePhilanthropyById(id);
        return "Ok";
    }

    @PutMapping("/{id}")
    public Philanthropy updatePhilanthropyById(@PathVariable Integer id, @RequestBody Philanthropy body) {
        body.setId(id);
        return this.philanthropyService.updatePhilanthropyById(id, body);
    }
}
