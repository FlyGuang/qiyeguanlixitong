package com.hs.service.impl;

import com.hs.dao.ProvinceDao;
import com.hs.po.Province;
import com.hs.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author km
 * 省的业务逻辑实现类
 */
@Service
public class ProvinceServiceIMPL implements ProvinceService {
   @Autowired
    ProvinceDao provinceDao;
    public List<Province> findAll(){
     return provinceDao.findAll();
    }

    public Province findObject(String provinceId){
        return provinceDao.findObject(provinceId);
    };
}
