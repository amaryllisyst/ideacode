package com.yst.controller;

import com.yst.entity.Admin;
import com.yst.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public  String login(String realname, String password,String enCode, HttpSession session){
        Admin admin = adminService.login(realname, password);
        String code=(String) session.getAttribute("randomString");
        System.out.println("------------login---before----------");
        if(code.equals(enCode)) {
            System.out.println("-------code  after  and  amin before---------------");
            if(admin!=null){
                System.out.println("-------admin after--------------"+admin.getId()+".."+admin.getPassword());
                session.setAttribute("admin",admin);
                return "redirect:/back/main/main.jsp";
            }else{
                System.out.println("-----admin--else --------------");
                return "redirect:/back/login.jsp"; }
        }else{
            System.out.println("------admin-da else--------------");
            return "redirect:/back/login.jsp";
        }
    };

    //  更新密码
    @RequestMapping("update")
    public @ResponseBody Boolean update(Admin admin, String originalPassword,String newePassword, HttpSession session) {
        Admin getAttributeAdmin = (Admin) session.getAttribute("admin");
        System.out.println("---originalPassword-------"+originalPassword+"---------new-password---------"+newePassword+"---------getPassord-----"+getAttributeAdmin.getPassword());
        if (originalPassword.equals(getAttributeAdmin.getPassword())) {
            admin.setId(getAttributeAdmin.getId());
            admin.setPassword(newePassword);
            session.setAttribute("admin",admin);
            adminService.modify(admin);
            return  true;
        }else{
            return  false;
        }
    }
//退出
    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.invalidate();
        return "redirect:/back/login.jsp";
    }

}

