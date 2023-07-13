package com.hs.service.impl;

import com.hs.dao.RecordDao;
import com.hs.po.Record;
import com.hs.service.RecordService;
import com.hs.vo.RecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author 陈晨
 * 会议记录业务逻辑实现类
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordDao recordDao;


    @Override
    public List<RecordVO> findVOAll() {
        return recordDao.findVOAll();
    }

    @Override
    public List<Record> findAll() {
        return recordDao.findAll();
    }

    @Override
    public RecordVO findVOByReid(int reid) {
        return recordDao.findVOByReid(reid);
    }

    @Override
    public Record findByReid(int reid) {
        return recordDao.findByReid(reid);
    }

    @Override
    public RecordVO findVOByMid(int mid) {
        return recordDao.findVOByMid(mid);
    }

    @Override
    public Record findByMid(int mid) {
        return recordDao.findByMid(mid);
    }

    @Override
    public List<RecordVO> findVOByRtime(Timestamp rtime) {
        return recordDao.findVOByRtime(rtime);
    }

    @Override
    public List<Record> findByRtime(Timestamp rtime) {
        return recordDao.findByRtime(rtime);
    }

    @Override
    public boolean add(Record record) {
        record.setRtime(new Timestamp(System.currentTimeMillis()));
        return recordDao.add(record)>0?true:false;
    }

    @Override
    public boolean update(Record record) {
        return recordDao.update(record)>0?true:false;
    }
}
