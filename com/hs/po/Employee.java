package com.hs.po;


import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author ss
 * 员工实体类
 */
public class Employee {
    /**
     * 员工编号
     */
    private  int eid;
    /**
     * 员工姓名
     */
    private String ename;
    /**
     * 性别
     */
    private String esex;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 电话
     */
    private String tel;
    /**
     * 地址
     */
    private String address;
    /**
     * 角色编号(外键,关联角色表)
     */
    private int rid;
    /**
     * 部门编号(外键,关联部门表)
     */
    private int did;
    /**
     * 员工状态表(外键,关联员工状态表)
     */
    private int esid;
    /**
     * 入职时间
     */
    private Date entrydate;

    /**
     * 无参构造器
     */
    public Employee() {
    }

    /**
     * 缺省id构造器
     * @param ename
     * @param esex
     * @param birthday
     * @param tel
     * @param address
     * @param rid
     * @param did
     * @param esid
     * @param entrydate
     */
    public Employee(String ename, String esex, Date birthday, String tel, String address, int rid, int did, int esid, Date entrydate) {
        this.ename = ename;
        this.esex = esex;
        this.birthday = birthday;
        this.tel = tel;
        this.address = address;
        this.rid = rid;
        this.did = did;
        this.esid = esid;
        this.entrydate = entrydate;
    }

    /**
     * 全参构造器
     * @param eid
     * @param ename
     * @param esex
     * @param birthday
     * @param tel
     * @param address
     * @param rid
     * @param did
     * @param esid
     * @param entrydate
     */
    public Employee(int eid, String ename, String esex, Date birthday, String tel, String address, int rid, int did, int esid, Date entrydate) {
        this.eid = eid;
        this.ename = ename;
        this.esex = esex;
        this.birthday = birthday;
        this.tel = tel;
        this.address = address;
        this.rid = rid;
        this.did = did;
        this.esid = esid;
        this.entrydate = entrydate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", esex='" + esex + '\'' +
                ", birthday=" + birthday +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", rid=" + rid +
                ", did=" + did +
                ", esid=" + esid +
                ", entrydate=" + entrydate +
                '}';
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getEsid() {
        return esid;
    }

    public void setEsid(int esid) {
        this.esid = esid;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }
}
