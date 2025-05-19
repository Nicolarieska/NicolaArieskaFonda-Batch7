/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;

import com.example.models.Philanthropy;
import com.example.models.PhilanthropyDetail;
import com.example.models.User;
import com.example.repository.PhilanthropyDetailRepository;
import com.example.repository.PhilanthropyRepository;
import com.example.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class PhilanthropyDetailService {

    @Autowired
    private PhilanthropyRepository philanthropyRepository;

    @Autowired
    private PhilanthropyDetailRepository philanthropyDetailRepository;

//    public PhilanthropyDetail createPhilanthropyDetail(User user, Integer philanthropyId, String amount,String type, String description) {
//        Philanthropy philanthropy = philanthropyRepository.findById(philanthropyId).orElse(null);
//
//        if (philanthropy == null) {
//            throw new RuntimeException("Philanthropy with id " + philanthropyId + " not found");
//        }
//
//        PhilanthropyDetail detail = new PhilanthropyDetail();
//        detail.setUser(user);
//        detail.setPhilanthropy(philanthropy);
//        detail.setAmount(amount);
//        detail.setType(type);
//        detail.setDescription(description);
//
//        return philanthropyDetailRepository.save(detail);
//    }
    public PhilanthropyDetail createPhilanthropyDetail(PhilanthropyDetail body) {
        return philanthropyDetailRepository.save(body);
    }

    public PhilanthropyDetail updatePhilanthropyDetail(Integer detailId, User user, Integer philanthropyId, String amount, String type, String description) {
        PhilanthropyDetail existingDetail = philanthropyDetailRepository.findById(detailId).orElse(null);
        if (existingDetail == null) {
            throw new RuntimeException("PhilanthropyDetail with id " + detailId + " not found");
        }

        Philanthropy philanthropy = philanthropyRepository.findById(philanthropyId).orElse(null);
        if (philanthropy == null) {
            throw new RuntimeException("Philanthropy with id " + philanthropyId + " not found");
        }

        existingDetail.setUser(user);
        existingDetail.setPhilanthropy(philanthropy);
        existingDetail.setAmount(amount);
        existingDetail.setType(type);
        existingDetail.setDescription(description);

        return philanthropyDetailRepository.save(existingDetail);
    }

}
