package com.yst.service;

import com.yst.dao.UserDAO;
import com.yst.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public void add(User user) {
        user.setUserId(UUID.randomUUID().toString());
        //这儿必须导对包   导包注意
        String salt = DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes());
        user.setUserSalt(salt);
        userDAO.insert(user);
    }

    @Override
    public void modify(User user) {
        if(user.getUserStatus().equals("活跃")){
            user.setUserStatus("冻结");
            userDAO.update(user);
      }else if(user.getUserStatus().equals("冻结")){
            user.setUserStatus("活跃");
            userDAO.update(user);
        }else{
            throw new  RuntimeException("内部错误.无法解析状态..");
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<User> findByPage(Integer page, Integer rows) {
         int start =(page-1)*rows;
        return userDAO.queryByPage(start,rows);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public User findOne(String id) {
        return userDAO.queryOne(id);
    }
}
