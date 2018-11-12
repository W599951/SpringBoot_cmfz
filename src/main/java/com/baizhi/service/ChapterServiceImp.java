package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImp implements ChapterService {

    @Autowired
    private ChapterDao chapterDao;
    @Override
    public void save(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString());
        chapter.setUpLoadDate(new Date());
        System.out.println(chapter);

        chapterDao.insert(chapter);
    }

    @Override
    public void remove(String id) {
        chapterDao.delete(id);
    }

    @Override
    public void motify(Chapter chapter) {
        chapterDao.update(chapter);
    }

    @Override
    public List<Chapter> findAll() {
        return chapterDao.findAll();
    }

    @Override
    public Chapter queryOne(String id) {
        return chapterDao.queryOne(id);
    }

    @Override
    public List<Chapter> findByPage(Integer page, Integer rows) {
        int status = (page-1)*rows;
        return chapterDao.findByPage(status,rows);
    }

    @Override
    public Long findTotals() {
        return chapterDao.findTotals();
    }
}
