package com.example.text_flow.service;

import com.example.text_flow.dao.BaseDao;
import com.example.text_flow.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public abstract class BaseService<T extends BaseEntity> {

    @Autowired
    private BaseDao<T> dao;

    @Transactional
    public List<T> getAll() {
        return dao.getAllList();
    }

    @Transactional
    public T getById(String id) {
        return dao.getById(id);
    }

    @Transactional
    public T save(T t) {
        return dao.save(t);
    }

    @Transactional
    public String deleteById(String id) {
        return dao.deleteById(id);
    }

}
