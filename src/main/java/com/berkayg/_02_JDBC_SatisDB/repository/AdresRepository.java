package com.berkayg._02_JDBC_SatisDB.repository;

import com.berkayg._02_JDBC_SatisDB.entity.Adres;

import java.util.List;
import java.util.Optional;

public class AdresRepository implements ICrud<Adres>{
    private DataBaseHelper dataBaseHelper;
    String sql;
    public AdresRepository() {
        this.dataBaseHelper = new DataBaseHelper();
    }

    @Override
    public void save(Adres adres) {
        sql="INSERT INTO tbladres(musteri_id,il,ilce,mahalle,adres) VALUES('%d','%s','%s','%s','%s')"
                .formatted(adres.getMusteri_id(),adres.getIl(),adres.getIlce(),adres.getMahalle(),adres.getAdres());
        dataBaseHelper.executeUpdate(sql);

    }

    @Override
    public void update(Adres adres) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Adres> findAll() {
        return null;
    }

    @Override
    public Optional<Adres> findById(int id) {
        return null;
    }
}
