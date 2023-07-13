package com.hs.service;

import com.hs.po.Leave;
import com.hs.po.LeaveType;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author jpc
 * 请假类型业务逻辑接口
 */

public interface LeaveTypeService {
    /**
     * 根据请假编号查询请假类型
     * @param ltid 请假类型编号
     * @return 请假类型
     */
    public LeaveType findById(int ltid);

    /**
     * 查询所有请假信息集合
     * @return 请假信息
     */
    public List<LeaveType> findAll();




}
