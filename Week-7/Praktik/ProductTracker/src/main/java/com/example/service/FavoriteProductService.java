/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;

import com.example.dto.FavoriteProductRequest;
import com.example.models.FavoriteProduct;
import com.example.models.Product;
import com.example.models.User;
import com.example.repository.FavoriteProductRepository;
import com.example.repository.UserRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Asus
 */
@Service
public class FavoriteProductService {

    @Autowired
    private FavoriteProductRepository favoriteProductRepository;

    @Autowired
    private UserRepository userRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public FavoriteProductService(FavoriteProductRepository favoriteProductRepository, UserRepository userRepository) {
        this.favoriteProductRepository = favoriteProductRepository;
        this.userRepository = userRepository;
    }

    public List<FavoriteProduct> getAllFavorites() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return favoriteProductRepository.findByUser(user);
    }

    public FavoriteProduct addFavoriteProduct(FavoriteProductRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        FavoriteProduct favorite = new FavoriteProduct();
        favorite.setProductId(request.getProductId());
        favorite.setTitle(request.getTitle());
        favorite.setDescription(request.getDescription());
        favorite.setCategory(request.getCategory());
        favorite.setUser(user);

        return favoriteProductRepository.save(favorite);
    }

    public void updateFavoritesFromExternalApi() {
        List<FavoriteProduct> favorites = favoriteProductRepository.findAll();

        for (FavoriteProduct favorite : favorites) {
            try {
                String url = "https://dummyjson.com/products/" + favorite.getProductId();
                ResponseEntity<Product> response = restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        Product.class
                );

                Product externalProduct = response.getBody();

                if (externalProduct != null) {
                    boolean isChanged
                            = !Objects.equals(favorite.getTitle(), externalProduct.getTitle())
                            || !Objects.equals(favorite.getDescription(), externalProduct.getDescription())
                            || !Objects.equals(favorite.getCategory(), externalProduct.getCategory());

                    if (isChanged) {
                        favorite.setTitle(externalProduct.getTitle());
                        favorite.setDescription(externalProduct.getDescription());
                        favorite.setCategory(externalProduct.getCategory());

                        favoriteProductRepository.save(favorite);
                    }
                }
            } catch (Exception e) {
                System.err.println("Failed to update product with ID: " + favorite.getProductId());
            }
        }
    }

    public void deleteFavoriteById(Integer id) {
        favoriteProductRepository.deleteById(id);
    }
}
