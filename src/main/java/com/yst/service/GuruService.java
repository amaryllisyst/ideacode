package com.yst.service;


import com.yst.entity.Guru;

import java.util.List;

public interface  GuruService  {
    public void add(Guru guru);
    public void remove(String id);
    public void modify(Guru guru);
    public List<Guru> findByPage(Integer page,Integer rows);
    public Long findTotals();
    public Guru findOne(String id);
}
