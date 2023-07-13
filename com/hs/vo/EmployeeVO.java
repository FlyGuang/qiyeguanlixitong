package com.hs.vo;

import com.hs.po.Dept;
import com.hs.po.Estate;
import com.hs.po.Role;

import java.sql.Date;

/**
 * @author km
 * 员工视图类
 */
public class EmployeeVO{
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
     * 角色
     */
    private Role role;
    /**
     * 部门
     */
    private Dept dept;
    /**
     * 员工状态
     */
    private Estate estate;
    /**
     * 入职时间
     */
    private Date entrydate;

    /**
     * 无参构造器
     */
    public EmployeeVO() {
    }

    public EmployeeVO(String ename, String esex, Date birthday, String tel, String address, Role role, Dept dept, Estate estate, Date entrydate) {
        this.ename = ename;
        this.esex = esex;
        this.birthday = birthday;
        this.tel = tel;
        this.address = address;
        this.role = role;
        this.dept = dept;
        this.estate = estate;
        this.entrydate = entrydate;
    }

    public EmployeeVO(int eid, String ename, String esex, Date birthday, String tel, String address, Role role, Dept dept, Estate estate, Date entrydate) {
        this.eid = eid;
        this.ename = ename;
        this.esex = esex;
        this.birthday = birthday;
        this.tel = tel;
        this.address = address;
        this.role = role;
        this.dept = dept;
        this.estate = estate;
        this.entrydate = entrydate;
    }

    @Override
    public String toString() {
        return "EmployeeVO{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", esex='" + esex + '\'' +
                ", birthday=" + birthday +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", dept=" + dept +
                ", estate=" + estate +
                ", entrydate=" + entrydate +
                '}';
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
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
    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

}
