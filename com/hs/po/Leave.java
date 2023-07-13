package com.hs.po;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author jpc
 * @author km
 * 请假实体类
 */
public class Leave {
    /**
     * 请假编号
     */
    private int lid;
    /**
     * 请假原因
     */
    private String reason;
    /**
     * 请假开始时间
     */
    private Timestamp start;
    /**
     * 请假结束时间
     */
    private Timestamp end;
    /**
     * 请假类型编号（外键，关联请假类型表）
     */
    private int ltid;
    /**
     * 员工编号（外键，关联员工表）
     */
    private int eid;
    /**
     * 审批状态编号（外键，关联审批状态表）
     */
    private int asid;
    /**
     * 请假状态
     */
    private String lstate;

    public Leave() {
    }

    @Override
    public String toString() {
        return "Leave{" +
                "lid=" + lid +
                ", reason='" + reason + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", ltid=" + ltid +
                ", eid=" + eid +
                ", asid=" + asid +
                ", lstate='" + lstate + '\'' +
                '}';
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public Leave(String reason, Timestamp start, Timestamp end, int ltid, int eid, int asid, String lstate) {
        this.reason = reason;
        this.start = start;
        this.end = end;
        this.ltid = ltid;
        this.eid = eid;
        this.asid = asid;
        this.lstate = lstate;
    }

    public Leave(int lid, String reason, Timestamp start, Timestamp end, int ltid, int eid, int asid, String lstate) {
        this.lid = lid;
        this.reason = reason;
        this.start = start;
        this.end = end;
        this.ltid = ltid;
        this.eid = eid;
        this.asid = asid;
        this.lstate = lstate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public Date getEnd() {
        return end;
    }


    public int getLtid() {
        return ltid;
    }

    public void setLtid(int ltid) {
        this.ltid = ltid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getAsid() {
        return asid;
    }

    public void setAsid(int asid) {
        this.asid = asid;
    }

    public String getLstate() {
        return lstate;
    }

    public void setLstate(String lstate) {
        this.lstate = lstate;
    }
}
