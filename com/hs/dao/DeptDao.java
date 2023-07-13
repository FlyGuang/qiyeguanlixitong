package com.hs.dao;

import com.hs.po.Dept;

import java.util.List;

/**
 * @author ss
 * 部门数据访问接口
 */
public interface DeptDao {

    /**
     * 查询所有部门
     * @return 部门对象集合
     */
    public List<Dept> findAll();

    /**
     * 根据部门id查询部门
     * @return 部门对象
     */
    public Dept findByDid(int did);

    /**
     * 通过名称查询部门
     * @param dname
     * @return
     */
    public Dept findByDname(String dname);

    /**
     * 新增部门
     * @return 受影响的行数
     */
    public int addDept(Dept dept);

    /**
     * 修改部门
     * @param dept 部门对象
     * @return 受影响的行数
     */
    public int updateDept(Dept dept);
}
