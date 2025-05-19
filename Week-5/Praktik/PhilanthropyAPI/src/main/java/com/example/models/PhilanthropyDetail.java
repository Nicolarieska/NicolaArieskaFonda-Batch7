/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "philanthropy_detail")
public class PhilanthropyDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pdtlid")
    private Integer pDtlId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false, referencedColumnName = "userid")
    private User user;

    @JsonBackReference(value = "default")
    @ManyToOne
    @JoinColumn(name = "pid", nullable = false, referencedColumnName = "pid")
    private Philanthropy philanthropy;

    private String amount;

//    @Enumerated(EnumType.STRING)
    private String type;

    private String description;

    public enum Type {
        donations,
        expenses
    }

    public Integer getPDtlId() {
        return pDtlId;
    }

    public void setPDtlId(Integer pDtlId) {
        this.pDtlId = pDtlId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Philanthropy getPhilanthropy() {
        return philanthropy;
    }

    public void setPhilanthropy(Philanthropy philanthropy) {
        this.philanthropy = philanthropy;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
