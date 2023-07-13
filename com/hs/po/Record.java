package com.hs.po;

import java.sql.Timestamp;

/**
 * @author cc
 * 会议记录实体类
 */
public class Record {
    /**
     * 会议记录编号
     */
    private int reid;
    /**
     * 会议编号
     */
    private int mid;
    /**
     * 会议内容
     */
    private String content;
    /**
     * 会议记录时间
     */
    private Timestamp rtime;

    public Record() {
    }

    public Record(int reid, int mid, String content, Timestamp rtime) {
        this.reid = reid;
        this.mid = mid;
        this.content = content;
        this.rtime = rtime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "reid=" + reid +
                ", mid=" + mid +
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

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
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
