package com.berkayg._01_JDBC_SchoolDB.repository;

import com.berkayg._01_JDBC_SchoolDB.entity.Ders;
import com.berkayg._01_JDBC_SchoolDB.entity.Ogrenci;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DersRepository implements ICrud<Ders> {
    private Crud crud;
    public DersRepository(){
        this.crud = new Crud();
    }

    public void save(Ders ders){
        String SQL_INSERT="INSERT INTO tblders(ad) VALUES('%s')"
                .formatted(ders.getAd());
        crud.executeUpdate(SQL_INSERT);
    }

    public void update(Ders ders){
        String SQL_UPDATE = "UPDATE tblders SET ad='%s' where id=%d"
                .formatted(ders.getAd(),ders.getId());
        crud.executeUpdate(SQL_UPDATE);
    }

    public void delete(int dersId){
        String SQL_DELETE = "DELETE FROM tblders  where id=%d"
                .formatted(dersId);
        crud.executeUpdate(SQL_DELETE);
    }

    public List<Ders> findAll() {
        String SQL_SELECT = "SELECT * FROM tblders";
        ResultSet resultSet = crud.executeQuery(SQL_SELECT);
        List<Ders> dersList = new ArrayList<>();
        try {
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String ad = resultSet.getString("ad");
                Ders ders = new Ders(id,ad);
                dersList.add(ders);

            }

        } catch (SQLException e) {
            System.out.println("Veri getirmede sorun oluşturdu....");


        }
        return dersList;

    }

    @Override
    public Ders findById(int id) {
        return null;
    }

}
