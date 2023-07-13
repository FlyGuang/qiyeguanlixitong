package com.hs.service.impl;

import com.hs.dao.LeaveTypeDao;
import com.hs.po.Leave;
import com.hs.po.LeaveType;
import com.hs.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jpc
 * 请假类型业务逻辑实现类
 */
@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {
    @Autowired
    LeaveTypeDao leaveTypeDao;


    @Override
    public LeaveType findById(int ltid) {
        return leaveTypeDao.findById(ltid);
    }

    @Override
    public List<LeaveType> findAll() {
        return leaveTypeDao.findAll();
    }


}
