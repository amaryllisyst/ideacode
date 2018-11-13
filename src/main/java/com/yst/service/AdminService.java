package com.yst.service;

import com.yst.entity.Admin;

public interface AdminService {
    public void register(Admin admin);
    public Admin login(String realname,String password);
    public void modify(Admin admin);
}
