package com.you07.location.h3cap.service;

import com.you07.location.h3cap.dao.H3cViewDao;
import com.you07.location.h3cap.model.H3cView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class H3cViewService {

    @Autowired
    private H3cViewDao h3cViewDao;

    public List<H3cView> queryAll(){
        return h3cViewDao.selectAll();
    }

    public int update(H3cView h3cView){
        return h3cViewDao.updateByPrimaryKeySelective(h3cView);
    }
}
