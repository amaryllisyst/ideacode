package com.yst.service;

import com.yst.dao.GuruDAO;
import com.yst.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDAO guruDAO;

    @Override
    public void add(Guru guru) {
        guru.setGuruId(UUID.randomUUID().toString());
        guruDAO.insert(guru);
    }
    @Override
    public void remove(String id) {
        guruDAO.delete(id);
    }
    @Override
    public void modify(Guru guru) {
        guruDAO.update(guru);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<Guru> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return  guruDAO.queryByPage(start,rows);
    }


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Long findTotals() {
        return guruDAO.queryTotals();
    }


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Guru findOne(String id) {
        return guruDAO.queryOne(id);
    }
}
