package com.hs.service.impl;

import com.hs.dao.PContractDao;
import com.hs.po.PContract;
import com.hs.service.PContractService;
import com.hs.vo.PContractVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author km
 * 项目合同业务逻辑实现类
 */
@Service
public class PContractServiceImpl implements PContractService {

    @Autowired
    PContractDao pContractDao;

    @Override
    public PContract findById(int id) {
        return pContractDao.findById(id);
    }

    @Override
    public PContractVO findVOById(int id) {
        return pContractDao.findVOById(id);
    }

    @Override
    public List<PContract> findAll() {
        return pContractDao.findAll();
    }

    @Override
    public List<PContractVO> findVOAll() {
        return pContractDao.findVOAll();
    }

    @Override
    public PContract findByPcid(String pcid) {
        return pContractDao.findByPcid(pcid);
    }

    @Override
    public PContractVO findVOByPcid(String pcid) {
        return pContractDao.findVOByPcid(pcid);
    }

    @Override
    public List<PContract> findByPartner(String partner) {
        return pContractDao.findByPartner(partner);
    }

    @Override
    public List<PContractVO> findVOByPartner(String partner) {
        return pContractDao.findVOByPartner(partner);
    }


    @Override
    public boolean add(PContract pContract) {
        pContract.setPcsid(1);
        return pContractDao.add(pContract)>0?true:false;
    }

    @Override
    public boolean update(PContract pContract) {
        return pContractDao.update(pContract)>0?true:false;
    }

    @Override
    public List<PContract> findByPid(int pid) {
        return pContractDao.findByPid(pid);
    }

    @Override
    public List<PContractVO> findVOByPid(int pid) {
        return  pContractDao.findVOByPid(pid);
    }
}
