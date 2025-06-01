/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.repository;

import com.example.models.FavoriteProduct;
import com.example.models.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Asus
 */
public interface FavoriteProductRepository extends JpaRepository<FavoriteProduct, Integer> {

    Optional<FavoriteProduct> findByUserAndTitle(User user, String title);
    List<FavoriteProduct> findByUser(User user);
}
