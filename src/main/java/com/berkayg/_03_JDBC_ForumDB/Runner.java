package com.berkayg._03_JDBC_ForumDB;

import com.berkayg._03_JDBC_ForumDB.controller.UserController;
import com.berkayg._03_JDBC_ForumDB.entity.User;
import com.berkayg._03_JDBC_ForumDB.repository.UserRepository;

import java.util.Optional;
import java.util.Scanner;

public class Runner {
    public static Scanner scanner = new Scanner(System.in);
    public static UserRepository userRepository = new UserRepository();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int secim;
        do {
            System.out.println("*** FORUM DB ***");
            System.out.println("1- Register");
            System.out.println("2- Login");
            System.out.println("0- CIKIS");
            System.out.println("Secim giriniz : ");
            secim = scanner.nextInt();
            switch (secim) {
                case 1: new UserController().register();
                    break;
                case 2:
                    new UserController().Login();
                    break;
                case 0:
                    System.out.println("Cikis yapildi...");
                default:
                    System.out.println("Gecersiz bir secim yapildi!!!!");
                    break;
            }
        } while (secim != 0);
        System.out.println("Program sonlandi");

    }


}
