package edu.miu.lelafoods.delivery.dao;

import java.util.List;

public interface GenericDeliveryDao<T> {

    void save(T t);
        void deleteById(Long id);
        T findOne(Long id);
        T update(T t);
        List<T> findAll();
}
