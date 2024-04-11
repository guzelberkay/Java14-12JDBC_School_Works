package com.berkayg._03_JDBC_ForumDB.repository;

import com.berkayg._03_JDBC_ForumDB.entity.Post;

import java.util.List;
import java.util.Optional;

public class PostRepository implements ICrud<Post> {
    private DataBaseHelper dataBaseHelper;
    String sql;

    public PostRepository() {
        this.dataBaseHelper = new DataBaseHelper();
    }

    @Override
    public boolean save(Post post) {
        sql = "INSERT INTO tblpost(userid, title, content, shareddate ) VALUES ('%d', '%s', '%s', '%d')"
                .formatted(post.getUserid(),post.getTitle(),post.getContent(),post.getSharedDate());

        return dataBaseHelper.executeUpdate(sql);
    }

    @Override
    public boolean update(Post post) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Optional<Post> findById(int id) {
        return Optional.empty();
    }
}
