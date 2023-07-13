package com.hs.service;

import com.hs.po.ApproveState;

import java.util.List;

/**
 * @author km
 * 审批状态业务逻辑接口
 */
public interface ApproveStateService {

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
