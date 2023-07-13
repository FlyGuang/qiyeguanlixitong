package com.hs.service.impl;

import com.hs.dao.StudyDao;
import com.hs.po.Study;
import com.hs.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author awei
 * 学习内容业务逻辑实现类
 */
@Service
public class StudyServiceImpl implements StudyService {

    @Autowired
    StudyDao studyDao;


    @Override
    public List<Study> findAll() {
        return studyDao.findAll();
    }

    @Override
    public Study findByStuid(int stuid) {
        return studyDao.findByStuid(stuid);
    }

    @Override
    public boolean addStudy(Study study) {
        return studyDao.addStudy(study)>0?true:false;
    }

    @Override
    public boolean update(Study study) {
        return studyDao.update(study)>0?true:false;
    }

    @Override
    public boolean delete(int stuid) {
        return studyDao.delete(stuid)>0?true:false;
    }
}
