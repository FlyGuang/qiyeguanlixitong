package com.hs.po;

import java.sql.Timestamp;

/**
 * @author bilie
 * 项目立项类
 */
public class Project {

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


    public Project() {
    }

    public Project(int pid, String pname, String pcontent, int eid, Timestamp pcreatetime, int asid, int ppid) {
        this.pid = pid;
        this.pname = pname;
        this.pcontent = pcontent;
        this.eid = eid;
        this.pcreatetime = pcreatetime;
        this.asid = asid;
        this.ppid = ppid;
    }

    @Override
    public String toString() {
        return "Project{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pcontent='" + pcontent + '\'' +
                ", eid=" + eid +
                ", pcreatetime=" + pcreatetime +
                ", asid=" + asid +
                ", ppid=" + ppid +
                '}';
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
}
