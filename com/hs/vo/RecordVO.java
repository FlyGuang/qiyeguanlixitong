package com.hs.vo;

import java.sql.Timestamp;

/**
 * @author 陈晨
 * 会议记录视图类
 */
public class RecordVO {
    /**
     * 会议记录编号
     */
    private int reid;
    /**
     * 会议视图
     */
    private MeetingVO meetingVO;
    /**
     * 会议内容
     */
    private String content;
    /**
     * 会议记录时间
     */
    private Timestamp rtime;

    public RecordVO() {
    }

    public RecordVO(int reid, MeetingVO meetingVO, String content, Timestamp rtime) {
        this.reid = reid;
        this.meetingVO = meetingVO;
        this.content = content;
        this.rtime = rtime;
    }

    @Override
    public String toString() {
        return "RecordVO{" +
                "reid=" + reid +
                ", meetingVO=" + meetingVO +
                ", content='" + content + '\'' +
                ", rtime=" + rtime +
                '}';
    }

    public int getReid() {
        return reid;
    }

    public void setReid(int reid) {
        this.reid = reid;
    }

    public MeetingVO getMeetingVO() {
        return meetingVO;
    }

    public void setMeetingVO(MeetingVO meetingVO) {
        this.meetingVO = meetingVO;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getRtime() {
        return rtime;
    }

    public void setRtime(Timestamp rtime) {
        this.rtime = rtime;
    }
}
