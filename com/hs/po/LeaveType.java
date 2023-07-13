package com.hs.po;

/**
 * @author jpc
 * 请假类型类
 */
public class LeaveType {
    /**
     * 请假类型编号（主键）
     */
    private int ltid;
    /**
     * 请假类型
     */
    private String ltype;

    public LeaveType() {
    }

    public LeaveType(int ltid, String ltype) {
        this.ltid = ltid;
        this.ltype = ltype;
    }

    public int getLtid() {
        return ltid;
    }

    public void setLtid(int ltid) {
        this.ltid = ltid;
    }

    public String getLtype() {
        return ltype;
    }

    public void setLtype(String ltype) {
        this.ltype = ltype;
    }
}
