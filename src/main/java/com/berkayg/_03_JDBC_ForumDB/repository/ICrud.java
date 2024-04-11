package com.berkayg._03_JDBC_ForumDB.repository;

import java.util.List;
import java.util.Optional;

public interface ICrud<T> {
    boolean save(T t);

    ;

    boolean update(T t);

    boolean delete(int id);

    List<T> findAll();

    Optional<T> findById(int id);

}
