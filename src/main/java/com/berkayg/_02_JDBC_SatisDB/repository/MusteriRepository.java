package com.berkayg._02_JDBC_SatisDB.repository;

import com.berkayg._02_JDBC_SatisDB.entity.Musteri;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MusteriRepository implements ICrud<Musteri> {
    private DataBaseHelper dataBaseHelper;
    String sql;

    public MusteriRepository() {
        this.dataBaseHelper = new DataBaseHelper();
    }

    @Override
    public void save(Musteri musteri) {

        sql = "INSERT INTO tblmusteriler(ad,soyad,cinsiyet,dtarih,email,tel) VALUES('%s','%s','%s','%d','%s','%s')"
                .formatted(musteri.getAd(), musteri.getSoyad(), musteri.getCinsiyet(), musteri.getDtarih(), musteri.getEmail(), musteri.getTel());
        dataBaseHelper.executeUpdate(sql);
    }

    @Override
    public void update(Musteri musteri) {
        sql = "UPDATE tblmusteriler SET ad='%s', soyad='%s', cinsiyet='%s', dtarih='%d', email='%s', tel='%s' WHERE id= '%d' "
                .formatted(musteri.getAd(), musteri.getSoyad(), musteri.getCinsiyet(), musteri.getDtarih(),
                        musteri.getEmail(), musteri.getTel(),musteri.getId());
        dataBaseHelper.executeUpdate(sql);
    }

    @Override
    public void delete(int id) {
        sql = "Delete from tblmusteriler where id=%d"
                .formatted(id);
        dataBaseHelper.executeUpdate(sql);
    }

    @Override
    public List<Musteri> findAll() {
        sql = "SELECT * FROM tblmusteriler ORDER BY id";
        ResultSet resultSet = dataBaseHelper.executeQuery(sql);
        List<Musteri> musteriList = new ArrayList<>();
        try {
            while (resultSet.next()) {

                Integer id = resultSet.getInt("id");
                String ad = resultSet.getString("ad");
                String soyad = resultSet.getString("soyad");
                String cinsiyet = resultSet.getString("cinsiyet");
                String email = resultSet.getString("email");
                String tel = resultSet.getString("tel");
                Long dtarih = resultSet.getLong("dtarih");
                int state = resultSet.getInt("state");
                Long createat = resultSet.getLong("createat");
                Long updateat = resultSet.getLong("updateat");

                Musteri m = new Musteri(id,ad,soyad,cinsiyet,dtarih,email,tel);
                m.setState(state);
                m.setCreateat(createat);
                m.setUpdateat(updateat);

                musteriList.add(m);

            }
        } catch (SQLException e) {
            System.out.println("Musteri listelemede bir hata olustu..."+e.getMessage());

        }
        return musteriList;
    }

    @Override
    public Optional<Musteri> findById(int idargs) {
        sql = "SELECT * FROM tblmusteriler WHERE id="+idargs;
        ResultSet resultSet = dataBaseHelper.executeQuery(sql);
        Musteri m = null;
        try {
                resultSet.next();  // ilk kaydı göstermesi içim kullanılır!!!

                Integer id = resultSet.getInt("id");
                String ad = resultSet.getString("ad");
                String soyad = resultSet.getString("soyad");
                String cinsiyet = resultSet.getString("cinsiyet");
                String email = resultSet.getString("email");
                String tel = resultSet.getString("tel");
                Long dtarih = resultSet.getLong("dtarih");
                int state = resultSet.getInt("state");
                Long createat = resultSet.getLong("createat");
                Long updateat = resultSet.getLong("updateat");

                m = new Musteri(id,ad,soyad,cinsiyet,dtarih,email,tel);
                m.setState(state);
                m.setCreateat(createat);
                m.setUpdateat(updateat);


        } catch (SQLException e) {
            e.printStackTrace();

        }
        return Optional.ofNullable(m);
    }
}







