package com.berkayg._01_JDBC_SchoolDB.repository;

import com.berkayg._01_JDBC_SchoolDB.entity.Ogrenci;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OgrenciRepository {

    private Crud crud;

    public OgrenciRepository() {
        this.crud = new Crud();
    }

    public void save(Ogrenci ogrenci) {
        //sql yaz
        String SQL_INSERT = "INSERT INTO tblogrenci(ad,soyad,yas,veliadi,iletisimtel) VALUES('%s', '%s', %d, '%s', '%s')"
                .formatted(ogrenci.getAd(), ogrenci.getSoyad(), ogrenci.getYas(), ogrenci.getVeliadi(), ogrenci.getIletisimtel());
        crud.executeUpdate(SQL_INSERT);


    }

    public void update(Ogrenci ogrenci) {
        String SQL_UPDATE = "UPDATE tblogrenci SET ad='%s', soyad='%s', yas=%d, veliadi='%s', iletisimtel='%s' where id=%d"
                .formatted(ogrenci.getAd(), ogrenci.getSoyad(), ogrenci.getYas(),
                           ogrenci.getVeliadi(), ogrenci.getIletisimtel(),ogrenci.getId());
        crud.executeUpdate(SQL_UPDATE);
    }

    public void delete(int id) {

    }

    public List<Ogrenci> findAll() {
        String SQL_SELECT = "SELECT * FROM tblogrenci";
        ResultSet resultSet = crud.executeQuery(SQL_SELECT);
        List<Ogrenci> ogrenciList = new ArrayList<>();
        try {
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String ad = resultSet.getString("ad");
                String soyad = resultSet.getString("soyad");
                int yas = resultSet.getInt("yas");
                String veliadi = resultSet.getString("veliadi");
                String iletisimtel = resultSet.getString("iletisimtel");

                Ogrenci ogrenci = new Ogrenci(id, ad, soyad, yas, veliadi, iletisimtel);  // ogrenci nesnesi oluşturduk
                ogrenciList.add(ogrenci);     // ogrencimizi listeye ekledik

            }
            return ogrenciList;

        } catch (SQLException e) {
            System.out.println("Veri getirmede sorun oluşturdu....");


        }
        return ogrenciList;

    }
}
