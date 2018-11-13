package com.yst.controller;

import com.yst.entity.User;
import com.yst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findByPage")
    public @ResponseBody
    List<User> findByPage(Integer page, Integer rows) {
        return    userService.findByPage(page,rows);
    }

    @RequestMapping("/modify")
    public @ResponseBody
    Map<String,Object> modify(User user){
        Map<String,Object> results=new HashMap<String,Object>();
        try{
            System.out.println("-----------------modify--user---"+user);
            userService.modify(user);
            results.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

}
