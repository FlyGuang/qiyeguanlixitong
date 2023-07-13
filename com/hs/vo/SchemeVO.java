package com.hs.vo;

import java.sql.Timestamp;

/**
 * @author bilie
 * 方案视图
 */
public class SchemeVO {

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
     * 项目编号
     */
    private int pid;

    /**
     * 项目名称
     */
    private String pname;

    /**
     * 项目内容
     */
    private String pcontent;

    /**
     * 项目负责人
     */
    private int eid;

    /**
     * 项目立项时间
     */
    private Timestamp pcreatetime;

    /**
     * 项目审批状态编号(外键)
     */
    private int asid;

    /**
     * 项目进度编号(外键)
     */
    private int ppid;

    /**
     * 部门编号(外键)
     */
    private int did;


    public SchemeVO() {
    }

    public SchemeVO(int scid, String sctitle, String scontent, int pid, String pname, String pcontent, int eid, Timestamp pcreatetime, int asid, int ppid, int did) {
        this.scid = scid;
        this.sctitle = sctitle;
        this.scontent = scontent;
        this.pid = pid;
        this.pname = pname;
        this.pcontent = pcontent;
        this.eid = eid;
        this.pcreatetime = pcreatetime;
        this.asid = asid;
        this.ppid = ppid;
        this.did = did;
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

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public Timestamp getPcreatetime() {
        return pcreatetime;
    }

    public void setPcreatetime(Timestamp pcreatetime) {
        this.pcreatetime = pcreatetime;
    }

    public int getAsid() {
        return asid;
    }

    public void setAsid(int asid) {
        this.asid = asid;
    }

    public int getPpid() {
        return ppid;
    }

    public void setPpid(int ppid) {
        this.ppid = ppid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
}
