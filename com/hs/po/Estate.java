package com.hs.po;

/**
 * @author ss
 * 员工状态实体类
 */
public class Estate {

    /**
     * 员工状态编号
     */
    private int esid;

    /**
     * 员工状态
     */
    private String estate;


    /**
     * 无参构造器
     */
    public Estate() {
    }

    /**
     * 全参构造器
     * @param esid
     * @param estate
     */
    public Estate(int esid, String estate) {
        this.esid = esid;
        this.estate = estate;
    }

    public int getEsid() {
        return esid;
    }

    public void setEsid(int esid) {
        this.esid = esid;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }
}
