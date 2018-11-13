package com.yst.service;

import com.yst.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findByPage(Integer page,Integer rows);
    void modify(User user);
    public User findOne(String id);
    //前端方法
    void add(User user);
}
