package com.hs.po;

import java.sql.Timestamp;

/**
 * @author awei
 * 劳动合同实体类
 */
public class LaborContract {

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

    public LaborContract() {
    }

    public LaborContract(String lcid, String lcaddr, int eid, Timestamp lcstart, Timestamp lcstop, int lcsid) {
        this.lcid = lcid;
        this.lcaddr = lcaddr;
        this.eid = eid;
        this.lcstart = lcstart;
        this.lcstop = lcstop;
        this.lcsid = lcsid;
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
}
