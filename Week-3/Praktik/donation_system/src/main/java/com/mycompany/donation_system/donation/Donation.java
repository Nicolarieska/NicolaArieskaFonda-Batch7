/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.donation_system.donation;

import com.mycompany.donation_system.Philanthropy.Philanthropy;
import com.mycompany.donation_system.user.User;

/**
 *
 * @author Asus
 */
public class Donation {

    private User user;
    private int amount;
    private Philanthropy philanthropy;

    public Donation(User user, int amount, Philanthropy philanthropy) {
        this.user = user;
        this.amount = amount;
        this.philanthropy = philanthropy;
    }

    public User getUser() {
        return user;
    }

    public int getAmount() {
        return amount;
    }

    public Philanthropy getPhilanthropy() {
        return philanthropy;
    }

    public String toString() {
        return "Username: " + user.getUser() + " Amount: " + amount + " To: " + philanthropy.getName() + "\nThank You for Your Donation!";
    }

}
