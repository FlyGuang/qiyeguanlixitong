package com.hs.po;

/**
 * @author awei
 * 项目合同状态类
 */
public class PcState {

    /**
     * 项目合同状态编号（主键）
     */
    private int pcsid;
    /**
     * 项目合同状态名称
     */
    private String pcstate;

    public PcState() {
    }

    public PcState(int pcsid, String pcstate) {
        this.pcsid = pcsid;
        this.pcstate = pcstate;
    }

    public int getPcsid() {
        return pcsid;
    }

    public void setPcsid(int pcsid) {
        this.pcsid = pcsid;
    }

    public String getPcstate() {
        return pcstate;
    }

    public void setPcstate(String pcstate) {
        this.pcstate = pcstate;
    }
}
