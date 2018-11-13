package com.yst.controller;

import com.yst.entity.Cource;
import com.yst.service.CourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cource")
public class CourceController {
    @Autowired
    private CourceService courceService;

    @RequestMapping("findAll")
    public @ResponseBody List<Cource> findAll(){
            return courceService.findAll();
    }


    @RequestMapping("/remove")
    public @ResponseBody
    Map<String,Object> remove(String id){
        Map<String,Object> results=new HashMap<String,Object>();
        try{
            courceService.remove(id);
            results.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }




    @RequestMapping("/add")
    public @ResponseBody Map<String, Object> add(Cource cource)throws Exception{
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            courceService.add(cource);
            results.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("message", e.getMessage());
            results.put("success", true);
        }
        return results;
    }

}
