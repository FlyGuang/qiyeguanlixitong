package com.hs.po;

/**
 * @author ss
 * 部门实体类
 */
public class Dept {
    /**
     * 部门编号
     */
    private int did;
    /**
     * 部门名称
     */
    private String dname;

    /**
     * 无参构造器
     */
    public Dept() {
    }

    /**
     * 全参构造器
     * @param did
     * @param dname
     */
    public Dept(int did, String dname) {
        this.did = did;
        this.dname = dname;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
}
