package com.baizhi.service;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class ArticleServiceImp implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public void save(Article article) {
        article.setId(UUID.randomUUID().toString());
        article.setReleaseDate(new Date());
        articleDao.insert(article);
    }

    @Override
    public void remove(String id) {
        articleDao.delete(id);
    }

    @Override
    public void motify(Article article) {
        articleDao.update(article);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> findAll() {
        return articleDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Article queryOne(String id) {
        return articleDao.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return articleDao.findByPage(start,rows);
    }

    @Override
    public Long findTotals() {
        return articleDao.findTotals();
    }
}
