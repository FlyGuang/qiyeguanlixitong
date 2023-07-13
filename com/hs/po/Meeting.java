package com.hs.po;


import java.sql.Timestamp;

/**
 * @author cc
 * 会议实体类
 */
public class Meeting {
    /**
     * 会议编号
     */
    private int mid;
    /**
     * 会议主题
     */
    private String mtitle;
    /**
     * 部门编号
     */
    private int did;
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

    public Meeting() {
    }

    public Meeting(int mid, String mtitle, int did, Timestamp meetingstart, Timestamp meetingstop, String meetingstate) {
        this.mid = mid;
        this.mtitle = mtitle;
        this.did = did;
        this.meetingstart = meetingstart;
        this.meetingstop = meetingstop;
        this.meetingstate = meetingstate;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "mid=" + mid +
                ", mtitle='" + mtitle + '\'' +
                ", did=" + did +
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

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
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
