package com.hs.service.impl;

import com.hs.dao.RoleDao;
import com.hs.po.Role;
import com.hs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author km
 * 角色业务逻辑实现类
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findById(int rid) {
        return roleDao.findById(rid);
    }

    @Override
    public Role findByRname(String rname) {
        return roleDao.findByRname(rname);
    }

    @Override
    public boolean addRole(Role role) {
        return roleDao.addRole(role)>0?true:false;
    }

    @Override
    public boolean updateRole(Role role) {
        return roleDao.updateRole(role)>0?true:false;
    }
}
