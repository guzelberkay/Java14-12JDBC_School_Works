package com.berkayg._00_JDBC_Baslangic;

import java.sql.*;

public class Runner {
    public static void main(String[] args) throws SQLException {
        //adresUpdate(10,"İstanbul","Beykoz");
        adresIleGoreListele("a");

    }

    private static void adresEkle(int musteri_id, String il, String ilce) throws SQLException {
        String ADRES_INSERT_SQL = "INSERT INTO tbladres(musteri_id,il,ilce) VALUES (" + musteri_id + ",'" + il + "','" + ilce + "')";
        String connectionString = "jdbc:postgresql://localhost:5432/SatisDB";
        String username = "postgres";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionString, username, password);

        PreparedStatement preparedStatement = connection.prepareStatement(ADRES_INSERT_SQL);
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            System.out.println("Kayıt başarı ile eklendi.");
        } else {
            System.out.println("Kaydetmede sorun var....");
        }
        connection.close();
    }

    private static void adresEklePrepared(int musteri_id, String il, String ilce) throws SQLException {
        String ADRES_INSERT_SQL = "INSERT INTO tbladres(musteri_id,il,ilce) VALUES (?,?,?)";
        String connectionString = "jdbc:postgresql://localhost:5432/SatisDB";
        String username = "postgres";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionString, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(ADRES_INSERT_SQL);
        preparedStatement.setInt(1, musteri_id);
        preparedStatement.setString(2, il);
        preparedStatement.setString(3, ilce);
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            System.out.println("Kayıt başarı ile eklendi.");
        } else {
            System.out.println("Kaydetmede sorun var....");
        }
        connection.close();

    }

    private static void adresSilPrepared(int idArgs)  {
        String ADRES_DELETE_SQL = "DELETE FROM tbladres WHERE id=?";
        String connectionString = "jdbc:postgresql://localhost:5432/SatisDB";
        String username = "postgres";
        String password = "root";
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(ADRES_DELETE_SQL);
        ) {
            preparedStatement.setInt(1, idArgs);

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Kayıt başarı ile silindi.");
            } else {
                System.out.println("Silmede sorun var....");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void adresUpdate(int adresId,String yeniIl,String yeniIlce){
        String ADRES_Update_SQL = "UPDATE tbladres SET il=?,ilce=? WHERE id=?";
        String connectionString = "jdbc:postgresql://localhost:5432/SatisDB";
        String username = "postgres";
        String password = "root";
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(ADRES_Update_SQL);
        ) {
            preparedStatement.setInt(3, adresId);
            preparedStatement.setString(1, yeniIl);
            preparedStatement.setString(2, yeniIlce);


            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Kayıt başarı ile guncellendi.");
            } else {
                System.out.println("Guncellemede sorun var....");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void adresIleGoreListele(String ilargs){
        String ADRES_SELECT_SQL = "SELECT * FROM tbladres WHERE il ILIKE ?";
        String connectionString = "jdbc:postgresql://localhost:5432/SatisDB";
        String username = "postgres";
        String password = "root";
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(ADRES_SELECT_SQL);
        ) {
            preparedStatement.setString(1, "%"+ilargs+"%");

           // DİKKAT! executeQuery kullanıldı. Select sorgularında dönen tablo sonuçlarını ResultSet yapısı getirir
            ResultSet resultSet = preparedStatement.executeQuery();
            // ResultSet next methodu ile cursoru bir sonraki kayıt varsa onu göstericek şekilde ilerletir.
          while(resultSet.next()){
              int musteriId = resultSet.getInt("musteri_id");
              String il = resultSet.getString("il");
              String ilce = resultSet.getString("ilce");
              System.out.println("Musteri_id: " +musteriId+" il: "+il+" ilce: "+ilce);
          }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
