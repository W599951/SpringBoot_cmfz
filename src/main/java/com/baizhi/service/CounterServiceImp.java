package com.baizhi.service;

import com.baizhi.dao.CounterDao;
import com.baizhi.entity.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class CounterServiceImp implements CounterService {

    @Autowired
    private CounterDao counterDao;

    @Override
    public void save(Counter counter) {
        counter.setId(UUID.randomUUID().toString());
        counter.setDate(new Date());
        counterDao.insert(counter);
    }

    @Override
    public void remove(String id) {
        counterDao.delete(id);
    }

    @Override
    public void motify(Counter counter) {
        counterDao.update(counter);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Counter> findAll() {
        return counterDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Counter queryOne(String id) {
        return counterDao.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Counter> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return counterDao.findByPage(start,rows);
    }

    @Override
    public Long findTotals() {
        return counterDao.findTotals();
    }
}
