package com.hs.service.impl;

import com.hs.dao.CityDao;
import com.hs.po.City;
import com.hs.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author km
 * 市的业务逻辑实现类
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityDao cityDao;
    public List<City> findCityByPid(String provinceId){
        return cityDao.findCityByPid(provinceId);
    }

    public City findObject(String cityId){
        return cityDao.findObject(cityId);
    }
}
