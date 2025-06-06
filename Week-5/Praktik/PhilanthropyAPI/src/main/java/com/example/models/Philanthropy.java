/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "philanthropy")
public class Philanthropy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @JsonManagedReference(value = "default")
    @OneToMany(mappedBy = "philanthropy", cascade = CascadeType.ALL)
    private List<PhilanthropyDetail> philanthropyDetails = new ArrayList<>();

    public List<PhilanthropyDetail> getPhilanthropyDetails() {
        return philanthropyDetails;
    }

    public void setPhilanthropyDetails(List<PhilanthropyDetail> philanthropyDetails) {
        this.philanthropyDetails = philanthropyDetails;
    }

    public Philanthropy() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
