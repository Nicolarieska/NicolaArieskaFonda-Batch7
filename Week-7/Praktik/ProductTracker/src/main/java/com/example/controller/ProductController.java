/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import com.example.models.Product;
import com.example.models.ProductWrapper;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api")
public class ProductController {

    private RestTemplate httpClient;

    public ProductController() {
        this.httpClient = new RestTemplate();
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        ResponseEntity<ProductWrapper> response = this.httpClient.exchange(
                "https://dummyjson.com/products?limit=10&skip=20",
                HttpMethod.GET,
                null,
                ProductWrapper.class
        );

        return response.getBody().getProducts();
    }
}
