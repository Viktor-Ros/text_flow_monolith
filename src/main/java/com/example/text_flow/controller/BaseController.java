package com.example.text_flow.controller;

import com.example.text_flow.entity.BaseEntity;
import com.example.text_flow.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T extends BaseEntity> {

    @Autowired
    BaseService<T> baseService;


    @PostMapping("")
    public T save(@RequestBody T t){
        return baseService.save(t);
    }

    @PutMapping("")
    public T update(@RequestBody T t){
        return baseService.save(t);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable String id){
        return baseService.deleteById(id);
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable String id){
        return baseService.getById(id);
    }

    @GetMapping("")
    public List<T> getAll(){
        return baseService.getAll();
    }

}
