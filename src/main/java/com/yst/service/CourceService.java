package com.yst.service;

import com.yst.entity.Cource;

import java.util.List;

public interface CourceService {
    List<Cource> findAll();
    void  add(Cource cource);
    void remove(String id);

}
