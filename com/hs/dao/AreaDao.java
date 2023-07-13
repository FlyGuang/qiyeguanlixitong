package com.hs.dao;

import com.hs.po.Area;

import java.util.List;

/**
 * @author km
 * 区县数据访问接口
 */
public interface AreaDao {
    /**
     * 根据市的编号查询区县的集合
     * @param cityId 市的编号
     * @return 区县的集合
     */
    public List<Area> findAreaByCid(String cityId);

    /**
     * 根据区县的编号查询市对象
     * @param AreaId 区县的编号
     * @return 区县的对象
     */
    public Area findObject(String AreaId);
}
