package com.hs.service.impl;

import com.hs.dao.MeetingDao;
import com.hs.po.Meeting;
import com.hs.service.MeetingService;
import com.hs.vo.MeetingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author 陈晨
 * 会议业务逻辑实现类
 */
@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    MeetingDao meetingDao;


    @Override
    public List<MeetingVO> findVOAll() {
        return meetingDao.findVOAll();
    }

    @Override
    public List<Meeting> findAll() {
        return meetingDao.findAll();
    }

    @Override
    public List<Meeting> findAllAsc() {
        return meetingDao.findAllAsc();
    }

    @Override
    public List<MeetingVO> findVOByMtitle(String mtitle) {
        return meetingDao.findVOByMtitle(mtitle);
    }

    @Override
    public List<Meeting> findByMtitle(String mtitle) {
        return meetingDao.findByMtitle(mtitle);
    }

    @Override
    public List<MeetingVO> findVOByMeetingstart(Timestamp meetingstart) {
        return meetingDao.findVOByMeetingstart(meetingstart);
    }

    @Override
    public List<Meeting> findByMeetingstart(Timestamp meetingstart) {
        return meetingDao.findByMeetingstart(meetingstart);
    }

    @Override
    public MeetingVO findVOByMid(int mid) {
        return meetingDao.findVOByMid(mid);
    }

    @Override
    public Meeting findByMid(int mid) {
        return meetingDao.findByMid(mid);
    }

    @Override
    public boolean update(Meeting meeting) {
        return meetingDao.update(meeting)>0?true:false;
    }

    @Override
    public boolean add(Meeting meeting) {
        meeting.setMeetingstate("未开始");
        return meetingDao.add(meeting)>0?true:false;
    }
}
