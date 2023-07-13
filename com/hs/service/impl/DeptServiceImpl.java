package com.hs.service.impl;

import com.hs.dao.DeptDao;
import com.hs.po.Dept;
import com.hs.service.DeptService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ss
 * 部门业务逻辑实现类
 */
@Service
public class DeptServiceImpl implements DeptService {


    @Autowired
    DeptDao deptDao;

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }

    @Override
    public Dept findByDid(int did) {
        return deptDao.findByDid(did);
    }

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept)>0?true:false;
    }

    @Override
    public Dept findByDname(String dname) {
        return deptDao.findByDname(dname);
    }

    @Override
    public boolean updeteDept(Dept dept) {
        return deptDao.updateDept(dept)>0?true:false;
    }
}
