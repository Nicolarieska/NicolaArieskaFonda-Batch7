/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import com.example.dto.FavoriteProductRequest;
import com.example.models.FavoriteProduct;
import com.example.service.FavoriteProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/me")
public class FavoriteProductController {

    @Autowired
    private FavoriteProductService favoriteProductService;

    public FavoriteProductController(FavoriteProductService favoriteProductService) {
        this.favoriteProductService = favoriteProductService;
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<FavoriteProduct>> getAllFavorites() {
        List<FavoriteProduct> favorites = favoriteProductService.getAllFavorites();
        return ResponseEntity.ok(favorites);
    }

    @PostMapping("/favorites")
    public ResponseEntity<FavoriteProduct> createFavorite(@RequestBody FavoriteProductRequest request) {
        FavoriteProduct favorite = favoriteProductService.addFavoriteProduct(request);
        return ResponseEntity.ok(favorite);
    }

    @PutMapping("/sync")
    public ResponseEntity<String> syncFavoritesFromExternalApi() {
        favoriteProductService.updateFavoritesFromExternalApi();
        return ResponseEntity.ok("Data Has Been Updated");
    }

    @DeleteMapping("/favorites/{id}")
    public ResponseEntity<String> deleteFavorite(@PathVariable Integer id) {
        try {
            favoriteProductService.deleteFavoriteById(id);
            return ResponseEntity.ok("Favorite product deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to delete favorite product");
        }
    }
}
