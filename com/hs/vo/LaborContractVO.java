package com.hs.vo;

import java.sql.Timestamp;

/**
 * @author awei
 * 劳动合同VO类
 */
public class LaborContractVO {

    /**
     * 劳动合同编号（主键）
     */
    private String lcid;
    /**
     * 劳动合同地址
     */
    private String lcaddr;
    /**
     * 员工编号
     */
    private int eid;
    /**
     * 员工姓名
     */
    private String ename;
    /**
     * 劳动合同生效时间
     */
    private Timestamp lcstart;
    /**
     * 劳动合同终止时间
     */
    private Timestamp lcstop;
    /**
     * 劳动合同状态编号（外键）
     */
    private int lcsid;
    /**
     * 劳动合同状态
     */
    private String lcstate;

    public LaborContractVO() {
    }

    @Override
    public String toString() {
        return "LaborContractVO{" +
                "lcid='" + lcid + '\'' +
                ", lcaddr='" + lcaddr + '\'' +
                ", eid=" + eid +
                ", ename='" + ename + '\'' +
                ", lcstart=" + lcstart +
                ", lcstop=" + lcstop +
                ", lcsid=" + lcsid +
                ", lcstate='" + lcstate + '\'' +
                '}';
    }

    public LaborContractVO(String lcid, String lcaddr, int eid, String ename, Timestamp lcstart, Timestamp lcstop, int lcsid, String lcstate) {
        this.lcid = lcid;
        this.lcaddr = lcaddr;
        this.eid = eid;
        this.ename = ename;
        this.lcstart = lcstart;
        this.lcstop = lcstop;
        this.lcsid = lcsid;
        this.lcstate = lcstate;
    }

    public String getLcid() {
        return lcid;
    }

    public void setLcid(String lcid) {
        this.lcid = lcid;
    }

    public String getLcaddr() {
        return lcaddr;
    }

    public void setLcaddr(String lcaddr) {
        this.lcaddr = lcaddr;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Timestamp getLcstart() {
        return lcstart;
    }

    public void setLcstart(Timestamp lcstart) {
        this.lcstart = lcstart;
    }

    public Timestamp getLcstop() {
        return lcstop;
    }

    public void setLcstop(Timestamp lcstop) {
        this.lcstop = lcstop;
    }

    public int getLcsid() {
        return lcsid;
    }

    public void setLcsid(int lcsid) {
        this.lcsid = lcsid;
    }

    public String getLcstate() {
        return lcstate;
    }

    public void setLcstate(String lcstate) {
        this.lcstate = lcstate;
    }
}
