package com.hs.dao;

import com.hs.po.City;
import java.util.List;

/**
 * @author km
 * 市的数据访问接口
 */
public interface CityDao {
    /**
     * 根据省的编号查询市的集合
     * @param provinceId 省的编号
     * @return 市的集合
     */
    public List<City> findCityByPid(String provinceId);

    /**
     * 根据市的编号查询市对象
     * @param cityId 市的编号
     * @return 市的对象
     */
    public City findObject(String cityId);
}
