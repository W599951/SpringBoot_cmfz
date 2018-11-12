package com.baizhi.service;

import com.baizhi.entity.Article;

import java.util.List;

public interface ArticleService {
    public void save(Article article);

    public void remove(String id);

    public void motify(Article article);

    List<Article> findAll();

    Article queryOne(String id);

    List<Article> findByPage(Integer page, Integer rows);

    Long findTotals();
}
