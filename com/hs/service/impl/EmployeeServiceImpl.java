package com.hs.service.impl;

import com.hs.dao.EmployeeDao;
import com.hs.po.Employee;
import com.hs.service.EmployeeService;
import com.hs.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * @author ss
 * 员工业务逻辑实现类
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<EmployeeVO> findAll() {
        return  employeeDao.findAll();
    }

    @Override
    public List<EmployeeVO> findNotlizhi() {
        return employeeDao.findNotlizhi();
    }

    @Override
    public EmployeeVO findVOByEid(int eid) {
        return employeeDao.findVOByEid(eid);
    }

    @Override
    public List<EmployeeVO> findByName(String ename) {
        return employeeDao.findByName(ename);
    }

    @Override
    public List<EmployeeVO> findByRid(int rid) {
        return employeeDao.findByRid(rid);
    }

    @Override
    public List<EmployeeVO> findByPid(int did) {
        return employeeDao.findByPid(did);
    }

    @Override
    public boolean updataEmployee(Employee employee) {
        return employeeDao.updataEmployee(employee)>0?true:false;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        employee.setEsid(1);
        employee.setEntrydate(new Date(System.currentTimeMillis()));
        return employeeDao.addEmployee(employee)>0?true:false;
    }

    @Override
    public Employee findByEid1(int eid) {
        return employeeDao.findByEid1(eid);
    }

    @Override
    public EmployeeVO findByTel(String tel) {
        return employeeDao.findByTel(tel);
    }

    @Override
    public Integer count() {
        return employeeDao.count();
    }

    @Override
    public Integer countworking() {
        return employeeDao.countworking();
    }
}

