package com.hs.service.impl;

import com.hs.dao.LcStateDao;
import com.hs.po.LaborContract;
import com.hs.po.LcState;
import com.hs.service.LcStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author awei
 * 劳动合同状态业务逻辑实现类
 */
@Service
public class LcStateServiceImpl implements LcStateService {

    @Autowired
    LcStateDao lcStateDao;


    @Override
    public List<LcState> findAll() {
        return lcStateDao.findAll();
    }

    @Override
    public LcState findByLcsid(int lcsid) {
        return lcStateDao.findByLcsid(lcsid);
    }
}
