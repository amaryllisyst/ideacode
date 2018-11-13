package com.yst.controller;

import com.yst.entity.Banner;
import com.yst.service.BannerService;
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
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("findByPage")
    public @ResponseBody
    Map<String, Object> findAll(Integer page, Integer rows) {
        Map<String, Object> results = new HashMap<String, Object>();
        List<Banner> pages = bannerService.findByPage(page, rows);
        Long total = bannerService.findTotals();
        results.put("total", total);
        results.put("rows", pages);
        return results;
    }



    @RequestMapping("/remove")
    public @ResponseBody
    Map<String, Object> remove(String id) {
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            bannerService.remove(id);
            results.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success", false);
            results.put("message", e.getMessage());
        }
        return results;
    }

    @RequestMapping("/modify")
    public @ResponseBody
    Map<String, Object> modify(Banner banner,MultipartFile upload,HttpSession session,String originalUpload) {
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            if (upload.getOriginalFilename().contains("jpg")||upload.getName().contains("png")||upload.getName().contains("gif")) {
            upload.transferTo(new File(session.getServletContext().getRealPath("upload/banner/") + "/" + upload.getOriginalFilename()));
            banner.setBannerImgPath("upload/banner/" + upload.getOriginalFilename());
            bannerService.modify(banner);
            results.put("success", true);
            } else if(upload.isEmpty()) {
                banner.setBannerImgPath(originalUpload);
                bannerService.modify(banner);
            }else{
                    throw new RuntimeException("图片处理异常。。。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            results.put("message", e.getMessage());
            results.put("success", false);
        }
        return results;
    }


    @RequestMapping("/queryOne")
    public @ResponseBody
    Banner queryOne(String id) {
        Banner banner = bannerService.queryOne(id);
        System.out.println("-------------queryone------------"+banner);
        return banner;
    }

    @RequestMapping("/deleteMore")
    public @ResponseBody
    Map<String, Object> deleteMore(String[] id) {
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            for (String s : id) {
                bannerService.remove(s);
            }
            results.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success", false);
            results.put("message", e.getMessage());
        }
        return results;
    }


 @RequestMapping("/add")
     public @ResponseBody Map<String, Object> add(MultipartFile upload, HttpSession session,Banner banner)throws Exception{
     Map<String, Object> results = new HashMap<String, Object>();
         System.out.println("--------------------------path-----------"+upload.getOriginalFilename());
     try {//获取所上传文件夹相对路径
         if (upload.getOriginalFilename().contains("jpg")||upload.getName().contains("png")||upload.getName().contains("gif")) {
             String realPath = session.getServletContext().getRealPath("upload/banner/");
             File destFile = new File(realPath + "/" + upload.getOriginalFilename());
             //转存到某个位置    替换以前的InputStream繁琐的代码
             System.out.println(destFile);
             upload.transferTo(destFile);
             banner.setBannerImgPath("upload/banner/" + upload.getOriginalFilename());
             bannerService.add(banner);
             results.put("success", true);
         }
     } catch (Exception e) {
             e.printStackTrace();
             results.put("message", e.getMessage());
             results.put("success", true);
         }
         return results;
     }

}