package com.hs.service.impl;

import com.hs.dao.ApproveStateDao;
import com.hs.po.ApproveState;
import com.hs.service.ApproveStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author km
 * 审批状态业务逻辑实现类
 */
@Service
public class ApproveStateImpl implements ApproveStateService {
    @Autowired
    ApproveStateDao approveStateDao;

    @Override
    public ApproveState findById (int asid) {
        return approveStateDao.findById(asid);
    }

    @Override
    public List<ApproveState> findAll() {
        return approveStateDao.findAll();
    }
}
