/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.donation_system;

import com.mycompany.donation_system.Philanthropy.Philanthropy;
import com.mycompany.donation_system.donation.Donation;
import com.mycompany.donation_system.user.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Donation_system {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Donation> donationList = new ArrayList<>();

        List<Philanthropy> pyList = new ArrayList<>();
        pyList.add(new Philanthropy('A', "A Hope Foundation"));
        pyList.add(new Philanthropy('B', "Bright Future Fund"));
        pyList.add(new Philanthropy('C', "Care & Share Org"));

        while (true) {
            System.out.println("=======================");
            System.out.println("       MAIN MENU       ");
            System.out.println("=======================");
            System.out.println("1. Donation         ");
            System.out.println("2. Donation History ");
            System.out.println("3. Exit             ");
            System.out.println("=======================");
            System.out.print("Choose an Option:   ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("==========================================");
                    System.out.println("               DONATION PAGE              ");
                    System.out.println("==========================================");
                    System.out.println("List of Philanthropy Organizations       ");
                    for (Philanthropy py : pyList) {
                        System.out.println(py.getId() + ". " + py.getName());
                    }
                    System.out.println("==========================================");
                    System.out.print("Entar Your Name : ");
                    String name = sc.next();
                    User user = new User(name);

                    System.out.print("Select Philanthropy (A B C): ");
                    char pys = sc.next().toUpperCase().charAt(0);

                    Philanthropy selectedPy = null;
                    for (Philanthropy py : pyList) {
                        if (py.getId() == pys) {
                            selectedPy = py;
                            break;
                        }
                    }

                    System.out.print("Enter Donation Amount : Rp. ");
                    int amount = sc.nextInt();

                    Donation donation = new Donation(user, amount, selectedPy);
                    donationList.add(donation);

                    System.out.println("==========================================");
                    System.out.println(donation);
                    break;
                case 2:
                    System.out.println("==========================================");
                    System.out.println("           DONATION HISTORY               ");
                    System.out.println("==========================================");

                    if (donationList.isEmpty()) {
                        System.out.println("No Donation History Yet");
                    } else {
                        for (Donation dhs : donationList) {
                            System.out.println(dhs.getPhilanthropy().getName());
                            System.out.println(dhs.getUser());
                            System.out.println(dhs.getAmount());
                            System.out.println("------------------------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println();
                    System.out.println("======================================");
                    System.out.println("  See you again in the next session.");
                    System.out.println("             Goodbye!              ");
                    System.out.println("======================================");
                    break;
                default:
                    System.out.println("Invalid Option.");
            }
            System.out.println();
        }
    }
}
