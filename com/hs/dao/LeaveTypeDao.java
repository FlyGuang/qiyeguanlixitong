package com.hs.dao;

import com.hs.po.LeaveType;

import java.util.List;

/**
 * @author jpc
 * 请假类型数据访问接口
 */
public interface LeaveTypeDao {
    /**
     * 通过请假类型编号查询请假类型对象
     * @param ltid 请假类型编号
     * @return 请假对象
     */
    public LeaveType findById(int ltid);


    /**
     * 查询所有请假类型集合
     * @return 请假类型集合
     */
    public List<LeaveType> findAll();
}
