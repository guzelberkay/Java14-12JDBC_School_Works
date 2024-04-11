package com.berkayg._01_JDBC_SchoolDB.repository;

import com.berkayg._01_JDBC_SchoolDB.entity.Ogrenci;

import java.util.List;

public interface ICrud<T> {
    void save(T t);;

    void update(T t);
    public void delete(int id);
    List<T> findAll();
    T findById(int id);

}
