package com.hs.po;

/**
 * @author cc
 * 个人收藏夹实体类
 */
public class Bookmarks {
    /**
     * 收藏夹编号
     */
    private int bmid;
    /**
     * 收藏夹名称
     */
    private String bmname;
    /**
     * 账号编号
     */
    private int aid;

    public Bookmarks() {
    }

    public Bookmarks(int bmid, String bmname, int aid) {
        this.bmid = bmid;
        this.bmname = bmname;
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "Bookmarks{" +
                "bmid=" + bmid +
                ", bmname='" + bmname + '\'' +
                ", aid=" + aid +
                '}';
    }

    public int getBmid() {
        return bmid;
    }

    public void setBmid(int bmid) {
        this.bmid = bmid;
    }

    public String getBmname() {
        return bmname;
    }

    public void setBmname(String bmname) {
        this.bmname = bmname;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
}
