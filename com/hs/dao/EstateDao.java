package com.hs.dao;

import com.hs.po.Estate;

import java.util.List;

/**
 * @author ss
 * 员工状态数据访问接口
 */
public interface EstateDao {

    /**
     * 查询所有状态
     */
    public List<Estate> findAll();

    /**
     * 根据id查询对应状态
     * @param esid
     * @return
     */
    public Estate findById(int esid);
}
