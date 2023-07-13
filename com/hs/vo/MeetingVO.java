package com.hs.vo;


import com.hs.po.Dept;

import java.sql.Timestamp;

/**
 * @author km
 * @author cc
 * 会议视图类
 */
public class MeetingVO {
    /**
     * 会议编号
     */
    private int mid;
    /**
     * 会议主题
     */
    private String mtitle;
    /**
     * 部门
     */
    private Dept dept;
    /**
     * 会议开始时间
     */
    private Timestamp meetingstart;
    /**
     * 会议结束时间
     */
    private Timestamp meetingstop;

    /**
     * 会议状态
     */
    private String meetingstate;

    public MeetingVO() {
    }

    public MeetingVO(String mtitle, Dept dept, Timestamp meetingstart, Timestamp meetingstop, String meetingstate) {
        this.mtitle = mtitle;
        this.dept = dept;
        this.meetingstart = meetingstart;
        this.meetingstop = meetingstop;
        this.meetingstate = meetingstate;
    }

    public MeetingVO(int mid, String mtitle, Dept dept, Timestamp meetingstart, Timestamp meetingstop, String meetingstate) {
        this.mid = mid;
        this.mtitle = mtitle;
        this.dept = dept;
        this.meetingstart = meetingstart;
        this.meetingstop = meetingstop;
        this.meetingstate = meetingstate;
    }

    @Override
    public String toString() {
        return "MeetingVO{" +
                "mid=" + mid +
                ", mtitle='" + mtitle + '\'' +
                ", dept=" + dept +
                ", meetingstart=" + meetingstart +
                ", meetingstop=" + meetingstop +
                ", meetingstate='" + meetingstate + '\'' +
                '}';
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Timestamp getMeetingstart() {
        return meetingstart;
    }

    public void setMeetingstart(Timestamp meetingstart) {
        this.meetingstart = meetingstart;
    }

    public Timestamp getMeetingstop() {
        return meetingstop;
    }

    public void setMeetingstop(Timestamp meetingstop) {
        this.meetingstop = meetingstop;
    }

    public String getMeetingstate() {
        return meetingstate;
    }

    public void setMeetingstate(String meetingstate) {
        this.meetingstate = meetingstate;
    }
}
