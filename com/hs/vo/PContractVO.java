package com.hs.vo;

import com.hs.po.Dept;
import com.hs.po.PcState;
import com.hs.po.Project;

import java.sql.Timestamp;

/**
 * @author km
 * 项目合同视图类
 */
public class PContractVO {
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
     * 项目视图
     */
    private ProjectVO projectVO;



    /**
     * 合同生效日期
     */
    private Timestamp pcstart;

    /**
     * 合同终止时间
     */
    private Timestamp pcstop;

    /**
     * 项目合同状态
     */
    private PcState pcstate;
    public PContractVO() {
    }

    public PContractVO(int id, String pcid, String pcaddr, String partner, ProjectVO projectVO, Timestamp pcstart, Timestamp pcstop, PcState pcstate) {
        this.id = id;
        this.pcid = pcid;
        this.pcaddr = pcaddr;
        this.partner = partner;
        this.projectVO = projectVO;
        this.pcstart = pcstart;
        this.pcstop = pcstop;
        this.pcstate = pcstate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PContractVO{" +
                "id=" + id +
                ", pcid='" + pcid + '\'' +
                ", pcaddr='" + pcaddr + '\'' +
                ", partner='" + partner + '\'' +
                ", projectVO=" + projectVO +
                ", pcstart=" + pcstart +
                ", pcstop=" + pcstop +
                ", pcstate=" + pcstate +
                '}';
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

    public ProjectVO getProjectVO() {
        return projectVO;
    }

    public void setProjectVO(ProjectVO projectVO) {
        this.projectVO = projectVO;
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

    public PcState getPcstate() {
        return pcstate;
    }

    public void setPcstate(PcState pcstate) {
        this.pcstate = pcstate;
    }

    public PContractVO(String pcid, String pcaddr, String partner, ProjectVO projectVO, Timestamp pcstart, Timestamp pcstop, PcState pcstate) {
        this.pcid = pcid;
        this.pcaddr = pcaddr;
        this.partner = partner;
        this.projectVO = projectVO;
        this.pcstart = pcstart;
        this.pcstop = pcstop;
        this.pcstate = pcstate;
    }
}
