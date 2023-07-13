package com.hs.service.impl;

import com.hs.dao.ExpenseDao;
import com.hs.po.Expense;
import com.hs.service.ExpenseService;
import com.hs.vo.ExpenseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jpc
 * @author km
 * 报销业务逻辑实现类
 */
@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    ExpenseDao expenseDao;


    @Override
    public List<Expense> findAll() {
        return expenseDao.findAll();
    }

    @Override
    public ExpenseVO findVOByExid(int exid) {
        return expenseDao.findVOByExId(exid);
    }

    @Override
    public boolean add(Expense expense) {
        expense.setAsid(1);
        return expenseDao.add(expense) > 0 ? true : false;
    }

    @Override
    public boolean delete(int exid) {
        return expenseDao.delete(exid) > 0 ? true : false;
    }

    @Override
    public Expense findByExid(int exid) {
        return expenseDao.findByExid(exid);
    }

    @Override
    public boolean update(Expense expense) {
        return expenseDao.update(expense)> 0 ? true : false;
    }

    @Override
    public List<ExpenseVO> findVOByEid(int eid) {
        return expenseDao.finByEid(eid);
    }

    @Override
    public List<ExpenseVO> findVOByAsid(int asid) {
        return expenseDao.findByAsid(asid);
    }

    @Override
    public List<ExpenseVO> findVOAll() {
        return expenseDao.findVOAll();
    }
}
