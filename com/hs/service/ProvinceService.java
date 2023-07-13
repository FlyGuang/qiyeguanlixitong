package com.hs.service;

import com.hs.po.Province;

import java.util.List;

/**
 * @author km
 * 省的业务逻辑接口
 */
public interface ProvinceService {
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
