package com.baizhi.service;

import com.baizhi.dao.CarouselDao;
import com.baizhi.entity.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class CarouselServiceImp implements CarouselService {

    @Autowired
    private CarouselDao carouselDao;

    @Override
    public void save(Carousel carousel) {
        carousel.setCreateDate(new Date());
        carousel.setId(UUID.randomUUID().toString());
        carouselDao.insert(carousel);
    }

    @Override
    public void remove(String id) {
        carouselDao.delete(id);
    }

    @Override
    public void motify(Carousel carousel) {
        carouselDao.update(carousel);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Carousel> findAll() {
        return carouselDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Carousel queryOne(String id) {
        return carouselDao.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Carousel> findByPage(Integer page, Integer rows) {
        int status = (page-1)*rows;
        List<Carousel> carouselList = carouselDao.findByPage(status, rows);
        return carouselList;
    }

    @Override
    public Long findTotals() {
        return carouselDao.findTotals();
    }
}
