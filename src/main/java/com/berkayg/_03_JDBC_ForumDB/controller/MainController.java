package com.berkayg._03_JDBC_ForumDB.controller;

import com.berkayg._03_JDBC_ForumDB.repository.LoggedUser;

import java.util.Random;
import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class MainController {

    private Scanner scanner = new Scanner(System.in);

    public void homePage(){
        System.out.println(STR."""
                *************************
                HOSGELDIN, \{LoggedUser.loggedUser.getUsername()}
                *************************
                
                1- Postlari Goruntule
                2- Post Paylas
                3- Kullanicilari Goruntule
                4- Logout(Login Ekranına Doner)
                """);
        System.out.println("Secim giriniz : ");
        int secim = scanner.nextInt(); scanner.nextLine();
        switch (secim) {
            case 1:
                break;
            case 2:

                break;
            case 3:
                break;

            case 4:
                break;
            default:

        }
    }

}
