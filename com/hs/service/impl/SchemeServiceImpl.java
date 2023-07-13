package com.hs.service.impl;

import com.hs.dao.SchemeDao;
import com.hs.po.Scheme;
import com.hs.service.SchemeService;
import com.hs.vo.SchemeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bilie
 * 项目方案业务逻辑实现类
 */
@Service
public class SchemeServiceImpl implements SchemeService {

    @Autowired
    SchemeDao schemeDao;

    @Override
    public List<Scheme> findAll() {
        return schemeDao.findAll();
    }

    @Override
    public List<SchemeVO> findVOAll() {
        return schemeDao.findVOAll();
    }

    @Override
    public List<Scheme> findByPid(int pid) {
        return schemeDao.findByPid(pid);
    }

    @Override
    public Scheme findByScid(int scid) {
        return schemeDao.findByScid(scid);
    }

    @Override
    public SchemeVO findByScidVO(int scid) {
        return schemeDao.findByScidVO(scid);
    }

    @Override
    public boolean update(Scheme scheme) {
        return schemeDao.update(scheme)>0?true:false;
    }

    @Override
    public boolean add(Scheme scheme) {
        return schemeDao.add(scheme)>0?true:false;
    }
}
