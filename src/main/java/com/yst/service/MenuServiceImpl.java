package com.yst.service;

import com.yst.dao.MenuDAO;
import com.yst.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDAO menuDAO;
    @Override
    public List<Menu> findAll() {
        return menuDAO.queryAll();
    }
}
