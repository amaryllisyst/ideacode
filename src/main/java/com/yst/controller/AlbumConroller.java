package com.yst.controller;

import com.yst.entity.Album;
import com.yst.service.AlbumService;
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
@RequestMapping("album")
public class AlbumConroller {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("findAll")
    public  @ResponseBody List<Album>  findAll(){
      return   albumService.findAll();
    }

    @RequestMapping("add")
    public @ResponseBody Map<String,Object> add(Album album, MultipartFile upload, HttpSession session){

        Map<String,Object> results=new HashMap<String,Object>();
        System.out.println("----contain?-----"+upload.getOriginalFilename().contains("jpg"));
        System.out.println("----contain?-da----"+upload.getOriginalFilename().contains("JPG"));
        System.out.println("----name-----"+upload.getOriginalFilename());
        try{
           if (upload.getOriginalFilename().contains("JPG")||upload.getOriginalFilename().contains("jpg")||upload.getOriginalFilename().contains("png")||upload.getOriginalFilename().contains("gif")) {
                System.out.println("--------m-----------if------------------" + upload.getOriginalFilename());
                upload.transferTo(new File(session.getServletContext().getRealPath("/upload/album") + "/" + upload.getOriginalFilename()));
                album.setAlbumConverPath("upload/album/" + upload.getOriginalFilename());
                albumService.add(album);
                results.put("success", true);
            }else{
               System.out.println("--------------------else------------null---------");
          }
        }catch(Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return  results;
    }

    @RequestMapping("findOne")
    public @ResponseBody Album findOne(String id) {
        return albumService.findOne(id);
    }

}
