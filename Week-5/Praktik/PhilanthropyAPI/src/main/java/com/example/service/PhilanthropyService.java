/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;

import com.example.models.Philanthropy;
import com.example.repository.PhilanthropyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class PhilanthropyService {

    @Autowired
    private PhilanthropyRepository repository;

    public List<Philanthropy> getAllPhilanthropies() {
        return repository.findAll();
    }

    public Optional<Philanthropy> getPhilanthropyById(Integer id) {
        return repository.findById(id);
    }

    public Philanthropy createPhilanthropy(Philanthropy philanthropy) {
        return repository.save(philanthropy);
    }

    public String deletePhilanthropyById(Integer id) {
        repository.deleteById(id);
        return "Deleted";
    }

    public Philanthropy updatePhilanthropyById(Integer id, Philanthropy philanthropy) {
        philanthropy.setId(id);
        return repository.save(philanthropy);
    }
}
