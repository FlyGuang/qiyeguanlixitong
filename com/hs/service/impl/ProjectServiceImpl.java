package com.hs.service.impl;

import com.hs.dao.ProjectDao;
import com.hs.po.Project;
import com.hs.service.ProjectService;
import com.hs.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author bilie
 * 项目立项业务逻辑实现类
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectDao projectDao;

    @Override
    public List<ProjectVO> findVOAll() {
        return projectDao.findVOAll();
    }

    @Override
    public List<ProjectVO> findVOByEid(int eid) {
        return projectDao.findVOByEid(eid);
    }


    @Override
    public ProjectVO findVOByPid(int pid) {
        return projectDao.findVOByPid(pid);
    }

    @Override
    public List<Project> findAll() {
        return projectDao.findAll();
    }

    @Override
    public List<Project> findByEid(int eid) {
        return projectDao.findByEid(eid);
    }


    @Override
    public Project findByPid(int pid) {
        return projectDao.findByPid(pid);
    }

    @Override
    public boolean add(Project project) {
        project.setAsid(1);
        project.setPpid(0);
        project.setPcreatetime(new Timestamp(System.currentTimeMillis()));
        return projectDao.add(project)>0?true:false;
    }

    @Override
    public boolean update(Project project) {
        return projectDao.update(project)>0?true:false;
    }

    @Override
    public List<ProjectVO> findVOByPname(String pname) {
        return projectDao.findVOByPname(pname);
    }
    @Override
    public List<Project> findByPname(String pname) {
        return projectDao.findByPname(pname);
    }

    @Override
    public List<ProjectVO> findVOByAsid(int asid) {
        return projectDao.finVOByAsid(asid);
    }

    @Override
    public Integer count() {
        return projectDao.count();
    }

    @Override
    public Integer countWait() {
        return projectDao.countWait();
    }

    @Override
    public List<ProjectVO> findVOPass() {
        return projectDao.findVOPass();
    }

    @Override
    public List<ProjectVO> finVOWait() {
        return projectDao.finVOWait();
    }
}
