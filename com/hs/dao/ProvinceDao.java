package com.hs.dao;

import com.hs.po.Province;

import java.util.List;

/**
 * @author km
 * 省的数据访问接口
 */
public interface ProvinceDao {
    /**
     * 查询所有省
     * @return 省的对象集合
     */
    public List<Province> findAll();

    /**
     * 根据省的编号查询省的对象
     * @param provinceId 省的编号
     * @return 省的对象
     */
    public Province findObject(String provinceId);
}
