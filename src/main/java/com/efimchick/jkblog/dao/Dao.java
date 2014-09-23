package com.efimchick.jkblog.dao;

import java.util.List;

/**
 * Created by Jerome on 16.07.2014.
 */
public interface  Dao <T> {
    T findById(Long id);
    T save(T t);
    void delete(T t);
    List<T> findAll(int pageNumber, int perPage);
    default List<T> findAll(){return findAll(0,0);};
}
