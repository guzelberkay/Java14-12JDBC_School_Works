package com.berkayg._03_JDBC_ForumDB.controller;

import com.berkayg._03_JDBC_ForumDB.entity.User;
import com.berkayg._03_JDBC_ForumDB.repository.LoggedUser;
import com.berkayg._03_JDBC_ForumDB.repository.UserRepository;

import java.util.Optional;
import java.util.Scanner;

public class UserController {
    public static Scanner scanner = new Scanner(System.in);
    private UserRepository userRepository;

    public UserController() {
        this.userRepository = new UserRepository();
    }

    public void register() {
        boolean isUserNameOK = false;
        System.out.println("""
                ********************************
                ************REGISTER************
                ********************************
                """);
        String username;
        boolean isUser;
        do {

            System.out.print("username: ");
            username = scanner.nextLine();
            isUser = userRepository.existUsername(username);
            if (isUser)
                System.out.println("Bu kullanici adi zaten mevcut.");

        } while (isUser);


        System.out.print("password: ");
        String password = scanner.nextLine();

        System.out.print("ad: ");
        String ad = scanner.nextLine();

        System.out.print("soyad: ");
        String soyad = scanner.nextLine();
        User user = new User(ad, soyad, username, password);

        userRepository.save(user);
    }

    public Optional<User> Login() {
        System.out.println("""
                ********************************
                *************LOGIN**************
                ********************************
                """);
        System.out.print("username: ");
        String username = scanner.nextLine();

        System.out.print("password: ");
        String password = scanner.nextLine();

       Optional<User> userOptional = userRepository.doLogin(username, password);
       if (userOptional.isPresent()){
           LoggedUser.loggedUser = userOptional.get();
           System.out.println("Giris basarili...");
           new MainController().homePage();
       }else {
           System.out.println("Kullnici adi veya sifre hatali!");
       }
       return  userRepository.doLogin(username,password);

    }

}
