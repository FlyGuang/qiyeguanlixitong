package com.hs.dao;

import com.hs.po.Expense;
import com.hs.vo.ExpenseVO;

import java.util.List;

/**
 * @author jpc
 * 报销数据访问接口
 */
public interface ExpenseDao {
    /** 新增报销
     * @param expense
     * @return 受影响行数
     */
    public int add(Expense expense);

    /**
     * 根据报销编号查询相应报销对象
     * @param exid 报销编号
     * @return 报销对象
     */
   public ExpenseVO findVOByExId(int exid);

    /**
     * 删除报销
     * @param exid
     * @return 受影响行数
     */
   public int delete(int exid);

    /**
     * 查询报销所有的信息
     * @return 报销所有的信息
     */
   public List<Expense> findAll();

    /**
     * 查询所有报销信息的视图
     * @return 报销所有信息视图
     */
   public List<ExpenseVO> findVOAll();

    public int update(Expense expense);

    public Expense findByExid(int exid);

    public List<ExpenseVO> finByEid(int eid);

    public List<ExpenseVO> findByAsid(int asid);
}
