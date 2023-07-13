package com.hs.vo;

/**
 * @author km
 * 账号视图类
 */
public class AccountVO {

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
     * 员工视图
     */
    private EmployeeVO employeeVO;

    /**
     * 账号状态
     */
    private String astate;

    /**
     * 无参构造器
     */
    public AccountVO() {
    }

    @Override
    public String toString() {
        return "AccountVO{" +
                "aid=" + aid +
                ", username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", employeeVO=" + employeeVO +
                ", astate='" + astate + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AccountVO(int aid, String username, String pass, EmployeeVO employeeVO, String astate) {
        this.aid = aid;
        this.username = username;
        this.pass = pass;
        this.employeeVO = employeeVO;
        this.astate = astate;
    }

    public AccountVO(String pass, EmployeeVO employeeVO, String astate) {
        this.pass = pass;
        this.employeeVO = employeeVO;
        this.astate = astate;
    }

    public AccountVO(int aid, String pass, EmployeeVO employeeVO, String astate) {
        this.aid = aid;
        this.pass = pass;
        this.employeeVO = employeeVO;
        this.astate = astate;
    }

    public int getAid() {
        return aid;
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

    public EmployeeVO getEmployeeVO() {
        return employeeVO;
    }

    public void setEmployeeVO(EmployeeVO employeeVO) {
        this.employeeVO = employeeVO;
    }

    public String getAstate() {
        return astate;
    }

    public void setAstate(String astate) {
        this.astate = astate;
    }
}
