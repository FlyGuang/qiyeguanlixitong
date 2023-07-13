package com.hs.service;

import com.hs.po.Role;

import java.util.List;

/**
 * @author km
 * 角色业务逻辑接口
 */
public interface RoleService {

    /**
     * 查询所有角色
     * @return 角色集合
     */
    public List<Role> findAll();

    /**
     * 通过id查询角色
     * @param rid
     * @return
     */
    public Role findById(int rid);

    /**
     * @param rname
     * @return
     */
    public Role findByRname(String rname);
    /**
     * 添加角色
     * @param role
     * @return 是否成功
     */
    public boolean addRole(Role role);
    /**
     * 修改角色
     * @param role
     * @return 是否成功
     */
    public boolean updateRole(Role role);
}
