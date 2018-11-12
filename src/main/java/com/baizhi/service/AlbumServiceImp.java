package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImp implements AlbumService {

    @Autowired
    private AlbumDao albumDao;
    @Override
    public void save(Album album) {
        album.setId(UUID.randomUUID().toString());
        album.setReleaseDate(new Date());
        albumDao.insert(album);
    }

    @Override
    public void remove(String id) {
        albumDao.delete(id);
    }

    @Override
    public void motify(Album album) {
        album.setReleaseDate(new Date());
        albumDao.update(album);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findAll() {
        return albumDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Album queryOne(String id) {
        return albumDao.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return albumDao.findByPage(start,rows);
    }

    @Override
    public Long findTotals() {
        return albumDao.findTotals();
    }
}
