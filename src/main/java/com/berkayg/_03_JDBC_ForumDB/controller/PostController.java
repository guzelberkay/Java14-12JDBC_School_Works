package com.berkayg._03_JDBC_ForumDB.controller;

import com.berkayg._03_JDBC_ForumDB.entity.Post;
import com.berkayg._03_JDBC_ForumDB.repository.LoggedUser;
import com.berkayg._03_JDBC_ForumDB.repository.PostRepository;

import java.util.Scanner;

public class PostController {
    private PostRepository postRepository ;

    public PostController(PostRepository postRepository) {
        this.postRepository = new PostRepository();
    }

    Scanner scanner = new Scanner(System.in);
    public void createNewPost(){
        System.out.println("""
                **********************************
                       POST PAYLASMA EKRANI
                **********************************
                """);
        System.out.println("Baslik....: ");
        String title = scanner.nextLine();
        System.out.println("Icerik....: ");
        String content = scanner.nextLine();

        Post newpost = new Post(LoggedUser.loggedUser.getId(), title, content);
        postRepository.save(newpost);
        System.out.println("Post basariyla paylasildi...");



    }
}
