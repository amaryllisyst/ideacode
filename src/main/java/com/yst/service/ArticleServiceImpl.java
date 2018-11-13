package com.yst.service;

import com.yst.dao.ArticleDAO;
import com.yst.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDAO articleDAO;

    @Override
    public void add(Article article) {
        articleDAO.insert(article);
    }

    @Override
    public void remove(String id) {
        articleDAO.delete(id);
    }

    @Override
    public void modify(Article article) {
        articleDAO.update(article);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> finAll() {
        return articleDAO.queryAll();
    }
}
