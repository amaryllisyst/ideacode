package com.yst.service;

import com.yst.dao.AdminDAO;
import com.yst.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl  implements AdminService{
    @Autowired
    private AdminDAO adminDAO;

    @Override
    public void register(Admin admin) {
        adminDAO.insert(admin);
    }

    @Override

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin login(String realname, String password) {
        return  adminDAO.login(realname,password);

    }

    @Override
    public void modify(Admin admin) {
        adminDAO.update(admin);
    }

}
