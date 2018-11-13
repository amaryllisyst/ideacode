package com.yst.service;

import com.yst.entity.Article;

import java.util.List;

public interface ArticleService {
    public void add(Article article);
    public void remove(String id);
    public void modify(Article article);
    public List<Article> finAll();
}
