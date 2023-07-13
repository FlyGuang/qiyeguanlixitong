package com.hs.po;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * @author bilie
 * 项目合同类
 */
public class PContract {
    private int id;
    /**
     * 项目合同编号
     */
    private String pcid;

    /**
     * 项目合同地址
     */
    private String pcaddr;

    /**
     * 合作伙伴
     */
    private String partner;

    /**
     * 项目编号(外键)
     */
    private int pid;

    /**
     * 合同生效日期
     */
    private Timestamp pcstart;

    /**
     * 合同终止时间
     */
    private Timestamp pcstop;

    /**
     * 项目合同状态编号
     */
    private int pcsid;



    public PContract() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String
    toString() {
        return "PContract{" +
                "id=" + id +
                ", pcid='" + pcid + '\'' +
                ", pcaddr='" + pcaddr + '\'' +
                ", partner='" + partner + '\'' +
                ", pid=" + pid +
                ", pcstart=" + pcstart +
                ", pcstop=" + pcstop +
                ", pcsid=" + pcsid +
                '}';
    }

    public PContract(int id, String pcid, String pcaddr, String partner, int pid, Timestamp pcstart, Timestamp pcstop, int pcsid) {
        this.id = id;
        this.pcid = pcid;
        this.pcaddr = pcaddr;
        this.partner = partner;
        this.pid = pid;
        this.pcstart = pcstart;
        this.pcstop = pcstop;
        this.pcsid = pcsid;
    }

    public PContract(String pcid, String pcaddr, String partner, int pid, Timestamp pcstart, Timestamp pcstop, int pcsid ){
        this.pcid = pcid;
        this.pcaddr = pcaddr;
        this.partner = partner;
        this.pid = pid;
        this.pcstart = pcstart;
        this.pcstop = pcstop;
        this.pcsid = pcsid;
    }


    public String getPcid() {
        return pcid;
    }

    public void setPcid(String pcid) {
        this.pcid = pcid;
    }

    public String getPcaddr() {
        return pcaddr;
    }

    public void setPcaddr(String pcaddr) {
        this.pcaddr = pcaddr;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Timestamp getPcstart() {
        return pcstart;
    }

    public void setPcstart(Timestamp pcstart) {
        this.pcstart = pcstart;
    }

    public Timestamp getPcstop() {
        return pcstop;
    }

    public void setPcstop(Timestamp pcstop) {
        this.pcstop = pcstop;
    }

    public int getPcsid() {
        return pcsid;
    }

    public void setPcsid(int pcsid) {
        this.pcsid = pcsid;
    }
}
