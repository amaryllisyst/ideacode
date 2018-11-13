package com.yst.controller;

import com.yst.entity.Guru;
import com.yst.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;

@RequestMapping("/findByPage")
    public @ResponseBody
    List<Guru> findByPage(Integer page,Integer rows) {
     return    guruService.findByPage(page,rows);
    }

 @RequestMapping("/add")
    public @ResponseBody   Boolean add(Guru guru, MultipartFile upload, HttpSession session){
        Map<String,Object> results=new HashMap<String,Object>();
     System.out.println("----upload.getName()--------------"+upload.getOriginalFilename());
        try{
            if (upload.getOriginalFilename().contains("jpg")||upload.getName().contains("png")||upload.getName().contains("gif")) {
                System.out.println("------------------e------------n-------------------");
                String realPath = session.getServletContext().getRealPath("/upload/guru");
                File destFile=new File(realPath+"/"+upload.getOriginalFilename());
                upload.transferTo(destFile);
                guru.setGuruAvatar("upload/guru/"+upload.getOriginalFilename());
                guruService.add(guru);
                System.out.println("----------if-----------"+results);
                return true;
            }
            System.out.println("-------------guru-------r----------"+guru);
            System.out.println("----------else------------"+results);
            return  false;
        }catch(Exception e){
            results.put("message",e.getMessage());
            System.out.println("--------------ctch--------"+results);
            return false;
        }

    }

 @RequestMapping("/remove")
    public @ResponseBody   Map<String,Object> remove(String id){
        Map<String,Object> results=new HashMap<String,Object>();
        try{
                guruService.remove(id);
                results.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

@RequestMapping("/modify")
    public @ResponseBody   Map<String,Object> modify(Guru guru,MultipartFile upload,HttpSession session,String originalUpload){
        Map<String,Object> results=new HashMap<String,Object>();
            // System.out.println("-m--empty?-----------"+upload.isEmpty());
             System.out.println("-m--empty?-----------"+upload.getOriginalFilename());
             System.out.println("-m--empty?-----------"+upload.getOriginalFilename());
        try{
            if (upload.getOriginalFilename().contains("JPG")||upload.getOriginalFilename().contains("jpg")||upload.getName().contains("png")||upload.getName().contains("gif")) {
               System.out.println("--------m-----------if------------------"+upload.getOriginalFilename());
                upload.transferTo(new File(session.getServletContext().getRealPath("/upload/guru") + "/" + upload.getOriginalFilename()));
                guru.setGuruAvatar("upload/guru/" + upload.getOriginalFilename());
                System.out.println("-----m------if------------"+guru);
                guruService.modify(guru);
            }else if(upload.isEmpty()){

                guru.setGuruAvatar(originalUpload);
               System.out.println("----m---else----------if-------------"+guru);
                guruService.modify(guru);
            }else{
                throw  new RuntimeException("内部错误");
              //  System.out.println("---m----else-----------?-------------");
            }


            results.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/findOne")
    public @ResponseBody   Guru findOne(String id) {
            return  guruService.findOne(id);
    }
@RequestMapping("/deleteMore")
    public @ResponseBody  Map<String, Object>  deleteMore(String[] id){
    Map<String, Object> results = new HashMap<String, Object>();
        try {
            for (String s : id) {
                guruService.remove(s);
            }
            results.put("success", true);
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
    return results;
    }
}
