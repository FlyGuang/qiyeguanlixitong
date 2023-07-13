package com.hs.po;

/**
 * @author bilie
 * 项目方案类
 */
public class Scheme {

    /**
     * 方案编号
     */
    private int scid;

    /**
     * 方案主题
     */
    private String sctitle;

    /**
     * 方案内容
     */
    private String scontent;

    /**
     * 项目编号(外键)
     */
    private int pid;

    public Scheme() {
    }

    public Scheme(int scid, String sctitle, String scontent, int pid) {
        this.scid = scid;
        this.sctitle = sctitle;
        this.scontent = scontent;
        this.pid = pid;
    }

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }

    public String getSctitle() {
        return sctitle;
    }

    public void setSctitle(String sctitle) {
        this.sctitle = sctitle;
    }

    public String getScontent() {
        return scontent;
    }

    public void setScontent(String scontent) {
        this.scontent = scontent;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
