package com.you07.location.h3cup.service;

import com.you07.location.h3cup.dao.H3cUpApDao;
import com.you07.location.h3cup.model.H3cUpAp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class H3cUpApService {
    @Autowired
    private H3cUpApDao h3cUpApDao;

    public List<H3cUpAp> getAll(){
        return h3cUpApDao.selectAll();
    }

    public List<H3cUpAp> selectNewData(){
        return h3cUpApDao.selectNewData();
    }

    public int update(H3cUpAp h3cUpAp){
        return h3cUpApDao.updateByPrimaryKeySelective(h3cUpAp);
    }
}
