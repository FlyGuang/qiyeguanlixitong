package com.hs.po;

/**
 * @author ss
 * @author km
 * 账号实体类
 */
public class Account {

    /**
     * 账号编号
     */
    private int aid;
    /**
     * 昵称
     */
    private String username;

    /**
     * 账号密码
     */
    private String pass;

    /**
     * 员工编号(外键,关联员工表)
     */
    private int eid;

    /**
     * 账号状态
     */
    private String astate;

    /**
     * 无参构造器
     */
    public Account() {
    }

    public Account(int aid, String username, String pass, int eid, String astate) {
        this.aid = aid;
        this.username = username;
        this.pass = pass;
        this.eid = eid;
        this.astate = astate;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 全参构造器
     * @param aid
     * @param pass
     * @param eid
     * @param astate
     */
    public Account(int aid, String pass, int eid, String astate) {
        this.aid = aid;
        this.pass = pass;
        this.eid = eid;
        this.astate = astate;
    }

    public int getAid() {
        return aid;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", eid=" + eid +
                ", astate='" + astate + '\'' +
                '}';
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getAstate() {
        return astate;
    }

    public void setAstate(String astate) {
        this.astate = astate;
    }
}
