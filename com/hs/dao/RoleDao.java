package com.hs.dao;

import com.hs.po.Dept;
import com.hs.po.Role;

import java.util.List;

/**
 * @author ss
 * @author km
 * 角色数据访问接口
 */
public interface RoleDao {

    /**
     * 查询所有角色
     * @return 角色集合
     */
    public List<Role> findAll();
    /**
     * 根据角色名查角色对象
     * @param rname 角色名
     * @return角色对象
     */
    public Role findByRname(String rname);
    /**
     * 通过id查询角色
     * @param rid
     * @return
     */
    public Role findById(int rid);

    /**
     * 添加角色
     * @param role
     * @return 首影响的行数
     */
    public int addRole(Role role);
    /**
     * 修改角色
     * @param role
     * @return 受影响的行数
     */
    public int updateRole(Role role);
}
