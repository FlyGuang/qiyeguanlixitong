package com.hs.service.impl;

import com.hs.dao.AreaDao;
import com.hs.po.Area;
import com.hs.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author km
 * 区县业务逻辑实现类
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaDao areaDao;
    @Override
    public List<Area> findAreaByCid(String cityId) {
        return areaDao.findAreaByCid(cityId);
    }

    @Override
    public Area findObject(String areaId) {
        return areaDao.findObject(areaId);
    }
}
