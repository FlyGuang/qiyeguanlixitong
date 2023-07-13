package com.hs.po;

/**
 * @author jpc
 * 审批状态表类
 */
public class ApproveState {
    /**
     * 审批状态编号(主键)
     */
    private int asid;
    /**
     * 审批状态
     */
    private String astate;

    public ApproveState() {
    }

    public ApproveState(int asid, String astate) {
        this.asid = asid;
        this.astate = astate;
    }

    public int getAsid() {
        return asid;
    }

    public void setAsid(int asid) {
        this.asid = asid;
    }

    public String getAstate() {
        return astate;
    }

    public void setAstate(String astate) {
        this.astate = astate;
    }
}
