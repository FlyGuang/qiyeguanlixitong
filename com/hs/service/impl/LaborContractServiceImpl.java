package com.hs.service.impl;

import com.hs.dao.LaborContractDao;
import com.hs.po.LaborContract;
import com.hs.service.LaborContractService;
import com.hs.vo.LaborContractVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author awei
 * 劳动合同业务逻辑实现类
 */
@Service
public class LaborContractServiceImpl implements LaborContractService {

    @Autowired
    LaborContractDao laborContractDao;

    @Override
    public List<LaborContractVO> findAllVO() {
        return laborContractDao.findAllVO();
    }

    @Override
    public LaborContractVO findVOByLcid(String lcid) {
        return laborContractDao.findVOByLcid(lcid);
    }

    @Override
    public LaborContract findByLcid(String lcid) {
        return laborContractDao.findByLcid(lcid);
    }

    @Override
    public List<LaborContract> findByEid(int eid) {
        return laborContractDao.findByEid(eid);
    }

    @Override
    public List<LaborContractVO> findVOByLcsid(int lcsid) {
        return laborContractDao.findVOByLcsid(lcsid);
    }


    @Override
    public List<LaborContract> findAll() {
        return laborContractDao.findAll();
    }

    @Override
    public boolean add(LaborContract laborContract) {
        laborContract.setLcsid(1);
        return laborContractDao.add(laborContract)>0?true:false;
    }

    @Override
    public boolean update(LaborContract laborContract) {
        return laborContractDao.update(laborContract)>0?true:false;
    }

    @Override
    public List<LaborContractVO> findVOByEid(int eid) {
        return laborContractDao.findVOByEid(eid);
    }
}
