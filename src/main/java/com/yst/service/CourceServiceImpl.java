package com.yst.service;

import com.yst.dao.CourceDAO;
import com.yst.entity.Cource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CourceServiceImpl implements CourceService {
    @Autowired
    private CourceDAO courceDAO;


    @Override
    public void add(Cource cource) {

        cource.setCourceId(UUID.randomUUID().toString());
        cource.setCourceCreateTime(new Date());
        courceDAO.insert(cource);
    }

    @Override
    public void remove(String id) {
        courceDAO.delete(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<Cource> findAll() {
        return courceDAO.queryAll();
    }
}
