package com.hs.service.impl;

import com.hs.dao.EstateDao;
import com.hs.po.Estate;
import com.hs.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ss
 * 员工状态业务逻辑实现类
 */
@Service
public class EstateServiceImpl implements EstateService {

    @Autowired
    EstateDao estateDao;

    @Override
    public List<Estate> findAll() {
        return estateDao.findAll();
    }

    @Override
    public Estate findById(int esid) {
        return estateDao.findById(esid);
    }
}
