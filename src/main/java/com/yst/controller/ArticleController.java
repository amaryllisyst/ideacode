package com.yst.controller;

import com.yst.entity.Article;
import com.yst.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("findAll")
    public @ResponseBody List<Article> findAll(){
        return articleService.finAll();
    }

    @RequestMapping("/add")
    public @ResponseBody
    Map<String, Object> add(Article article)throws Exception{
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            articleService.add(article);
            results.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("message", e.getMessage());
            results.put("success", true);
        }
        return results;
    }


    @RequestMapping("/remove")
    public @ResponseBody
    Map<String, Object> remove(String id) {
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            articleService.remove(id);
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
    Map<String, Object> modify(Article article) {
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            articleService.modify(article);
            results.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("message", e.getMessage());
            results.put("success", false);
        }
        return results;
    }





}
