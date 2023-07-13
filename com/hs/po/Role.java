package com.hs.po;

/**
 * @author ss
 * 角色实体类
 */
public class Role {
    private int rid;
    private String rname;

    /**
     * 无参构造器
     */
    public Role() {
    }

    /**
     * 全参构造器
     * @param rid
     * @param rname
     */
    public Role(int rid, String rname) {
        this.rid = rid;
        this.rname = rname;
    }

    public Role(String rname) {
        this.rname=rname;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                '}';
    }
}
