package com.hs.service;

import com.hs.po.Project;
import com.hs.vo.ProjectVO;

import java.util.List;

/**
 * @author bilie
 * 项目立项业务逻辑接口
 */
public interface ProjectService {
    /**
     * 查询所有项目立项视图
     * @return 项目立项视图的集合
     */
    public List<ProjectVO> findVOAll();

    /**
     * 根据员工编号查询
     * @param eid 员工编号
     * @return 项目立项视图的集合
     */
    public List<ProjectVO> findVOByEid(int eid);


    /**
     * 根据项目编号查询码项目对象
     * @param pid 项目编号
     * @return 项目视图对象
     */
    public ProjectVO findVOByPid(int pid);
    /**
     * 查询所有项目立项
     * @return 项目立项的集合
     */
    public List<Project> findAll();

    /**
     * 根据员工编号查询
     * @param eid 员工编号
     * @return 项目立项的集合
     */
    public List<Project> findByEid(int eid);


    /**
     * 根据项目编号查询码项目对象
     * @param pid 项目编号
     * @return 项目对象
     */
    public Project findByPid(int pid);

    /**
     * 新增一个项目
     * @param project 项目对象
     * @return 受影响的行数
     */
    public boolean add(Project project);

    /**
     * 审批项目(修改项目状态)
     * @param project 项目对象
     * @return 受影响的行数
     */
    public boolean update(Project project);

    public List<ProjectVO> findVOByPname(String pname);
    public List<Project> findByPname(String pname);

    public List<ProjectVO> findVOByAsid(int asid);


    /**
     * 计算项目总数
     * @return
     */
    public Integer count();

    /**
     * 计算待审批项目数量
     * @return
     */
    public Integer countWait();

    /**
     * 查询已通过审批的项目视图
     * @return 项目视图集合
     */
    public List<ProjectVO> findVOPass();

    /**
     * 查询待审批项目
     * @return
     */
    public List<ProjectVO> finVOWait();
}
