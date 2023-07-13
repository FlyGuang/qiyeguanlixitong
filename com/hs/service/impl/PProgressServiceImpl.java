package com.hs.service.impl;

import com.hs.dao.PProgressDao;
import com.hs.dao.ProjectDao;
import com.hs.po.PProgress;
import com.hs.service.PProgressService;
import com.hs.service.ProjectService;
import com.hs.vo.Progress;
import com.hs.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bilie
 * 项目进度业务逻辑实现类
 */
@Service
public class PProgressServiceImpl implements PProgressService {

    @Autowired
    PProgressDao pProgressDao;

    @Autowired
    ProjectDao projectDao;

    @Override
    public List<PProgress> findall() {
        return pProgressDao.findall();
    }

    @Override
    public List<Progress> findNum() {
        return pProgressDao.findNum();
    }

    @Override
    public Map<String, List> toshow() {
        Map<String,List> map = new HashMap<>();
        List<ProjectVO> list = projectDao.findVOAll();
        List<String> name = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        for (ProjectVO projectVO:list){
            if (projectVO.getApprovestate().getAstate().equals("通过")){
                name.add(projectVO.getPname());
                value.add(pProgressDao.findByPpid(projectVO.getPprogress().getPpid()).getPpnum());
            }
        }
        map.put("names",name);
        map.put("values",value);
        return map;
    }

    @Override
    public PProgress findByPpid(int ppid) {
        return pProgressDao.findByPpid(ppid);
    }

    @Override
    public boolean add(PProgress pProgress) {
        return pProgressDao.add(pProgress)>0?true:false;
    }

    @Override
    public boolean update(PProgress pProgress) {
        return pProgressDao.update(pProgress)>0?true:false;
    }
}
