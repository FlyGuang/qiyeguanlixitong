package com.hs.dao;

import com.hs.po.ApproveState;

import java.util.List;

/**
 * @author jpc
 * 审批状态数据访问接口
 */
public interface ApproveStateDao {

    /**
     * 根据审批状态编号查询审批状态
     * @param asid 审批状态编号
     * @return 审批状态对象
     */
    public ApproveState findById(int asid);

    /**
     * 查询所有的审批状态
     * @return  审批状态对象集合
     */
    public List<ApproveState> findAll();
}
