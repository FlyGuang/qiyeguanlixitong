package com.hs.service.impl;

import com.hs.dao.CollectDao;
import com.hs.po.Collect;
import com.hs.service.CollectService;
import com.hs.vo.CollectChartVo;
import com.hs.vo.CollectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陈晨
 * 收藏内容业务逻辑实现类
 */
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectDao collectDao;


    @Override
    public List<CollectVO> findVOAll() {
        return collectDao.findVOAll();
    }

    @Override
    public List<Collect> findAll() {
        return collectDao.findAll();
    }

    @Override
    public CollectVO findVOByCid(int cid) {
        return collectDao.findVOByCid(cid);
    }

    @Override
    public Collect findByCid(int cid) {
        return collectDao.findByCid(cid);
    }

    @Override
    public List<CollectVO> findVOByBmid(int bmid) {
        return collectDao.findVOByBmid(bmid);
    }

    @Override
    public List<Collect> findByBmid(int bmid) {
        return collectDao.findByBmid(bmid);
    }

    @Override
    public CollectVO findVOByStuid(int stuid) {
        return collectDao.findVOByStuid(stuid);
    }

    @Override
    public Collect findByStuid(int stuid) {
        return collectDao.findByStuid(stuid);
    }

    @Override
    public boolean add(Collect collect) {
        return collectDao.add(collect)>0?true:false;
    }

    @Override
    public boolean update(Collect collect) {
        return collectDao.update(collect)>0?true:false;
    }

    @Override
    public boolean delete(int[] array) {
        return collectDao.delete(array)>0?true:false;
    }

    @Override
    public List<CollectChartVo> findStat() {
        return collectDao.findStat();
    }

    @Override
    public Map<String, List> findBar() {
        Map<String,List> map=new HashMap<>();
        List<CollectChartVo> list=this.findStat();
        List<String> names=new ArrayList<>();
        List<Integer> values=new ArrayList<>();
        for(CollectChartVo collectChartVo:list){
            names.add(collectChartVo.getStutitle());
            values.add(collectChartVo.getValue());
        }
        map.put("names",names);
        map.put("values",values);
        return map;
    }
}
