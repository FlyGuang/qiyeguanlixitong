package com.hs.po;

/**
 * @author bilie
 * 项目进度表
 */
public class PProgress {

    /**
     * 项目进度编号
     */
    private int ppid;

    /**
     * 项目进度
     */
    private int ppnum;

    public PProgress() {
    }

    public PProgress(int ppid, int ppnum) {
        this.ppid = ppid;
        this.ppnum = ppnum;
    }

    public int getPpid() {
        return ppid;
    }

    public void setPpid(int ppid) {
        this.ppid = ppid;
    }

    public int getPpnum() {
        return ppnum;
    }

    public void setPpnum(int ppnum) {
        this.ppnum= ppnum;
    }
}
