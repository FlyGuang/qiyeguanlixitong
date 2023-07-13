package com.hs.service;

import com.hs.po.Employee;
import com.hs.vo.EmployeeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ss
 * 员工业务逻辑接口
 */
public interface EmployeeService {

    /**
     * 查询全部员工
     * @return 员工视图对象集合
     */
    public List<EmployeeVO> findAll();

    /**
     * 查询全部未离职员工
     * @return
     */
    public List<EmployeeVO> findNotlizhi();


    /**
     * 通过员工编号查询员工
     * @return 员工视图对象
     */
    public EmployeeVO findVOByEid(int eid);

    /**
     * 通过员工姓名模糊查询
     * @return 员工视图对象集合
     */
    public List<EmployeeVO> findByName(@Param("ename") String ename);

    /**
     * 根据角色编号查询员工
     * @return 员工视图对象集合
     */
    public List<EmployeeVO> findByRid(int rid);

    /**
     * 通过部门编号查询员工
     * @return 员工视图对象集合
     */
    public List<EmployeeVO> findByPid(int did);

    /**
     * 通过电话查询员工对象
     * @param tel 员工电话
     * @return 员工对象
     */
    public EmployeeVO findByTel(String tel);

    /**
     * 修改员工资料
     * @param employee
     * @return 是否修改成功
     */
    public boolean updataEmployee(Employee employee);

    /**
     * 添加员工
     * @return 是否添加成功
     */
    public boolean addEmployee(Employee employee);


    /**
     * 通过员工id查找一个员工对象
     * @param eid
     * @return
     */
    public Employee findByEid1(int eid);

    /**
     * 查询所有员工数量
     * @return
     */
    public Integer count();

    /**
     * 查询在岗人数
     * @return
     */
    public Integer countworking();
}
