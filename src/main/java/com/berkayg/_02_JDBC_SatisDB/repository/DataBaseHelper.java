package com.berkayg._02_JDBC_SatisDB.repository;

import java.sql.*;

import static com.berkayg._02_JDBC_SatisDB.utility.Constants.*;

public class DataBaseHelper {

    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    private boolean openConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME, DB_USERNAME, DB_PASSWORD);
            return true;
        } catch (SQLException e) {
            System.out.println("Baglanti acma hatasi...: " + e.getMessage());
            return false;
        }
    }

    private void closeConnection() {
        try {
            if (!conn.isClosed()) {
                conn.close();
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Baglanti kapatma hatasi...: " + e.getMessage());
        }
    }

    public boolean executeUpdate(String SQL){

        try {
            if (openConnection()){
                conn.prepareStatement(SQL).executeUpdate();
                closeConnection();
                return true;
            }else {
                System.out.println("Baglanti acilamadi...");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Sorgu calistirilamadi...SQL kodunda hata olabilir... "+e.getMessage());
            return false;
        }

    }

    public ResultSet executeQuery(String SQL){

        try {
            if (openConnection()){
                ResultSet rs = conn.prepareStatement(SQL).executeQuery();
                closeConnection();
                return rs;
            }else {
                System.out.println("Baglanti acilamadi...");
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Sorgu calistirilamadi...SQL kodunda hata olabilir... "+e.getMessage());
            return null;
        }
    }
}
