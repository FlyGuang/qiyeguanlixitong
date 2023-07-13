package com.hs.po;

/**
 * @author awei
 * 劳动合同状态类
 */
public class LcState {

    /**
     * 劳动合同状态编号（主键）
     */
    private int lcsid;
    /**
     * 劳动合同状态名称
     */
    private String lcstate;

    public LcState() {
    }

    public LcState(int lcsid, String lcstate) {
        this.lcsid = lcsid;
        this.lcstate = lcstate;
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
