package com.hs.dao;

import com.hs.po.Meeting;
import com.hs.vo.MeetingVO;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author cc
 * 会议数据访问接口
 */
public interface MeetingDao {
    /**
     * 查找所有的会议
     * @return 会议集合视图
     */
    public List<MeetingVO> findVOAll();

    /**
     * 查找所有的会议
     * @return 会议集合
     */
    public List<Meeting> findAll();

    /**
     * 根据时间顺序查询会议
     * @return 会议列表
     */
    public List<Meeting> findAllAsc();

    /**
     * 根据会议主题模糊查询会议集合
     * @param mtitle 会议主题
     * @return 会议集合视图
     */
    public List<MeetingVO> findVOByMtitle(@Param("mtitle") String mtitle);
    /**
     * 根据会议主题模糊查询会议集合
     * @param mtitle 会议主题
     * @return 会议集合
     */
    public List<Meeting> findByMtitle(@Param("mtitle") String mtitle);

    /**
     * 根据会议开始时间查找会议
     * @param meetingstart 会议开始时间
     * @return 会议集合视图
     */
    public List<MeetingVO> findVOByMeetingstart(Timestamp meetingstart);
    /**
     * 根据会议开始时间查找会议
     * @param meetingstart 会议开始时间
     * @return 会议集合
     */
    public List<Meeting> findByMeetingstart(Timestamp meetingstart);

    /**
     * 根据会议编号查找会议对象
     * @param mid 会议编号
     * @return 会议对象视图
     */
    public MeetingVO findVOByMid(int mid);
    /**
     * 根据会议编号查找会议对象
     * @param mid 会议编号
     * @return 会议对象
     */
    public Meeting findByMid(int mid);
    /**
     * 更新会议
     * @param meeting 会议对象
     * @return 受影响的行数
     */
    public int update(Meeting meeting);

    /**
     * @param meeting 会议对象
     * @return 受影响的行数
     */
    public int add(Meeting meeting);
}
