package com.hs.service.impl;

import com.hs.dao.LeaveDao;
import com.hs.po.Leave;
import com.hs.service.LeaveService;
import com.hs.vo.LeaveVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author km
 * 请假业务逻辑实现类
 */
@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    LeaveDao leaveDao;
    @Override
    public boolean add(Leave leave) {
        leave.setAsid(1);
        leave.setLstate("未销假");
        return leaveDao.add(leave)>0?true:false;
    }

    @Override
    public Leave findById(int lid) {
        return leaveDao.findById(lid);
    }

    @Override
    public LeaveVO findVOById(int lid) {
        return leaveDao.findVOById(lid);
    }

    @Override
    public List<LeaveVO> findVOAll() {
        return leaveDao.findVOAll();
    }

    @Override
    public List<Leave> findAll() {
        return leaveDao.findAll();
    }

    @Override
    public List<Leave> findByLstate(String lstate) {
        return leaveDao.findByLstate(lstate);
    }

    @Override
    public List<LeaveVO> findVOByLstate(String lstate) {
        return leaveDao.findVOByLstate(lstate);
    }

    @Override
    public boolean delete(int lid) {
        return leaveDao.delete(lid)>0?true:false;
    }

    @Override
    public boolean update(Leave leave) {
        return leaveDao.update(leave)>0?true:false;
    }

    @Override
    public List<LeaveVO> findVOByEid(int eid) {
        return leaveDao.findVOByEid(eid);
    }

    @Override
    public List<LeaveVO> findVOByAsid(int asid) {
        return leaveDao.findVOByAsid(asid);
    }
}
