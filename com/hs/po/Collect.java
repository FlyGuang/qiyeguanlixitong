package com.hs.po;

/**
 * @author cc
 * 收藏内容实体类
 */
public class Collect {
    /**
     * 收藏编号
     */
    private int cid;
    /**
     * 学习内容编号
     */
    private int stuid;
    /**
     * 收藏夹编号
     */
    private int bmid;

    public Collect() {
    }

    public Collect(int cid, int stuid, int bmid) {
        this.cid = cid;
        this.stuid = stuid;
        this.bmid = bmid;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "cid=" + cid +
                ", stuid=" + stuid +
                ", bmid=" + bmid +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public int getBmid() {
        return bmid;
    }

    public void setBmid(int bmid) {
        this.bmid = bmid;
    }
}
