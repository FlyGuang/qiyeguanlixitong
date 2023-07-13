package com.hs.service.impl;

import com.hs.dao.PcStateDao;
import com.hs.po.PContract;
import com.hs.po.PcState;
import com.hs.service.PcStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bilie
 * 项目合同业务逻辑实现类
 */
@Service
public class PcStateServiceImpl implements PcStateService {

    @Autowired
    PcStateDao pcStateDao;

    @Override
    public PcState findByPcsid(int pcsid) {
        return pcStateDao.findByPcsid(pcsid);
    }

    @Override
    public List<PcState> findAll() {
        return pcStateDao.findAll();
    }
}
