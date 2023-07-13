package com.hs.service;

import com.hs.dao.EstateDao;
import com.hs.po.Estate;

import java.util.List;

/**
 * @author ss
 * 员工状态业务逻辑接口
 */
public interface EstateService {

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
