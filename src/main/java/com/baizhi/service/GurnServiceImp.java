package com.baizhi.service;

import com.baizhi.dao.GurnDao;
import com.baizhi.entity.Gurn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GurnServiceImp implements GurnService {

    @Autowired
    private GurnDao gurnDao;

    @Override
    public void save(Gurn gurn) {
        System.out.println("service:   " +gurn);
        gurn.setId(UUID.randomUUID().toString());
        gurnDao.insert(gurn);
    }

    @Override
    public void remove(String id) {
        gurnDao.delete(id);
    }

    @Override
    public void motify(Gurn gurn) {

        gurnDao.update(gurn);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Gurn> findAll() {
        return gurnDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Gurn queryOne(String id) {
        return gurnDao.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Gurn> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return gurnDao.findByPage(start,rows);
    }

    @Override
    public Long findTotals() {
        return gurnDao.findTotals();
    }
}
