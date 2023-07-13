package com.hs.po;

/**
 * @author jpc
 * 报销表类
 */
public class Expense {
    /**
     * 报销编号(主键)
     */
    private int exid;
    /**
     * 报销金额
     */
    private Double money;
    /**
     * 员工编号（外键，关联员工表）
     */
    private int eid;
    /**
     * 报销资料文件地址
     */
    private String  efaddr;

    /**
     * 报销细则
     */
    private String econtent;

    /**
     * 审批状态编号（外键，关联审批状态表）
     */
    private int  asid;

    public Expense(Double money, int eid, String efaddr, String econtent, int asid) {
        this.money = money;
        this.eid = eid;
        this.efaddr = efaddr;
        this.econtent = econtent;
        this.asid = asid;
    }
    public Expense(int exid, Double money, int eid, String efaddr, String econtent, int asid) {
        this.exid = exid;
        this.money = money;
        this.eid = eid;
        this.efaddr = efaddr;
        this.econtent = econtent;
        this.asid = asid;
    }


    public Expense() {
    }

    public Expense(int exid, Double money, int eid, String efaddr, int asid) {
        this.exid = exid;
        this.money = money;
        this.eid = eid;
        this.efaddr = efaddr;
        this.asid = asid;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "exid=" + exid +
                ", money=" + money +
                ", eid=" + eid +
                ", efaddr='" + efaddr + '\'' +
                ", econtent='" + econtent + '\'' +
                ", asid=" + asid +
                '}';
    }

    public String getEcontent() {
        return econtent;
    }

    public void setEcontent(String econtent) {
        this.econtent = econtent;
    }

    public int getExid() {
        return exid;
    }

    public void setExid(int exid) {
        this.exid = exid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEfaddr() {
        return efaddr;
    }

    public void setEfaddr(String efaddr) {
        this.efaddr = efaddr;
    }

    public int getAsid() {
        return asid;
    }

    public void setAsid(int asid) {
        this.asid = asid;
    }
}
