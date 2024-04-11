package com.berkayg._03_JDBC_ForumDB.repository;

import com.berkayg._03_JDBC_ForumDB.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserRepository implements ICrud<User> {
    private DataBaseHelper dataBaseHelper;
    String sql;

    public UserRepository() {
        this.dataBaseHelper = new DataBaseHelper();
    }

    @Override
    public boolean save(User user) {

        sql = "INSERT INTO tbluser(username, password, ad, soyad ) VALUES ('%s', '%s', '%s', '%s')"
                .formatted(user.getUsername(), user.getPassword(), user.getAd(), user.getSoyad());

        return dataBaseHelper.executeUpdate(sql);


    }

    @Override
    public boolean update(User user) {
        sql = "UPDATE tbluser SET ad = '%s', soyad = '%s', username = '%s', password = '%s' where id = %d"
                .formatted(user.getAd(), user.getSoyad(), user.getUsername(), user.getPassword(), user.getId());
        return dataBaseHelper.executeUpdate(sql);
    }

    @Override
    public boolean delete(int silinecekid) {

        sql = "Delete from tbluser where id=%d"
                .formatted(silinecekid);
        return dataBaseHelper.executeUpdate(sql);
    }


    @Override
    public List<User> findAll() {
        sql = "";
        ResultSet resultSet = dataBaseHelper.executeQuery(sql);
        return null;
    }

    @Override
    public Optional<User> findById(int id) {
        sql = "";
        ResultSet resultSet = dataBaseHelper.executeQuery(sql);
        return Optional.empty();
    }

    public Optional<User> doLogin(String username, String password) {
        sql = "SELECT * FROM tbluser WHERE username = '" + username + "' AND password = '" + password + "'";
        ResultSet resultSet = dataBaseHelper.executeQuery(sql);
        Optional<User> user = Optional.empty();

        try {
            if (resultSet.next()) {
                long rsid = resultSet.getLong("id");
                String rsad = resultSet.getString("ad");
                String rssoyad = resultSet.getString("soyad");
                String rspassword = resultSet.getString("password");
                String reusername = resultSet.getString("username");

                user = Optional.of(new User(rsid, rsad, rssoyad, reusername, rspassword));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean existUsername(String username) {
        sql = "SELECT * FROM tbluser WHERE username = '" + username + "'";
        ResultSet resultSet = dataBaseHelper.executeQuery(sql);

        boolean existUser = false;
        try {
            existUser = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existUser;


    }
}
