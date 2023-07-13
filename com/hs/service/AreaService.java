package com.hs.service;

import com.hs.po.Area;
import com.hs.po.Leave;

import java.util.List;

/**
 * @author km
 * 区县业务逻辑接口
 */
public interface AreaService {
    /**
     * 根据市的编号查询区县的集合
     * @param cityId 市的编号
     * @return 区县的集合
     */
    public List<Area> findAreaByCid(String cityId);

    /**
     * 根据区县的编号查询市对象
     * @param areaId 区县的编号
     * @return 区县的对象
     */
    public Area findObject(String areaId);


}
