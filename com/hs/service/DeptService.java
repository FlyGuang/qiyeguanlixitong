package com.hs.service;

import com.hs.po.Dept;

import java.util.List;

/**
 * @author ss
 * 部门业务逻辑接口
 */
public interface DeptService {

    /**
     * 查询所有部门
     * @return
     */
    public List<Dept> findAll();

    /**
     * 根据编号查询部门
     * @param did
     * @return
     */
    public Dept findByDid(int did);

    /**
     * 根据名称查询部门
     * @param dname
     * @return
     */
    public Dept findByDname(String dname);

    /**
     * 新增部门
     * @param dept
     * @return 是否添加成功
     */
    public boolean addDept(Dept dept);

    /**
     * 修改部门
     * @param dept
     * @return 是否添加成功
     */
    public boolean updeteDept(Dept dept);


}
