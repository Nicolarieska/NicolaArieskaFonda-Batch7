/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.donation_system.user;

/**
 *
 * @author Asus
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public void setUser(String name) {
        this.name = name;
    }

    public String getUser() {
        return name;
    }

    @Override
    public String toString() {
        return "User Name: " + name;
    }
}
