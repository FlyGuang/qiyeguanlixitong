package com.hs.service;

import com.hs.po.Expense;
import com.hs.vo.ExpenseVO;

import java.util.List;

/**
 * @author jpc
 * 报销的业务逻辑接口
 */
public interface ExpenseService {
    /**
     * 查询所有的报销信息集合
     * @return 报销信息
     */
    public List<Expense> findAll();

    /**
     * 查询所有的报销信息视图集合
     * @return 报销信息视图
     */
    public List<ExpenseVO> findVOAll();

    /**
     * 根据报销编号查询到报销信息
     * @param exid 报销编号
     * @return 报销信息
     */
    public ExpenseVO findVOByExid(int exid);

    /**
     * 新增报销信息
     * @param expense
     * @return 是否新增成功
     */
    public boolean add(Expense expense);

    /**
     * 删除报销信息
     * @param exid
     * @return 是否删除成功
     */
    public boolean delete(int exid);

    public Expense findByExid(int exid);

    public  boolean update(Expense expense);

    public List<ExpenseVO> findVOByEid(int eid);

    public List<ExpenseVO> findVOByAsid(int asid);
}
