package com.berkayg._02_JDBC_SatisDB.repository;

import java.util.List;
import java.util.Optional;

public interface ICrud<T> {
    void save(T t);;

    void update(T t);
    public void delete(int id);
    List<T> findAll();
    Optional<T> findById(int id);

}
