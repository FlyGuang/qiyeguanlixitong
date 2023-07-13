package com.hs.vo;

import com.hs.po.ApproveState;
import com.hs.po.Employee;

/**
 * @author km
 * 报销视图类
 */
public class ExpenseVO {
    /**
     * 报销编号(主键)
     */
    private int exid;
    /**
     * 报销金额
     */
    private Double money;
    /**
     * 员工视图对象
     */
    private EmployeeVO employeeVO;
    /**
     * 报销资料文件地址
     */
    private String  efaddr;
    private String econtent;
    /**
     * 审批状态
     */
    private ApproveState approveState;

    public ExpenseVO() {
    }

    public ExpenseVO(int exid, Double money, EmployeeVO employeeVO, String efaddr, String econtent, ApproveState approveState) {
        this.exid = exid;
        this.money = money;
        this.employeeVO = employeeVO;
        this.efaddr = efaddr;
        this.econtent = econtent;
        this.approveState = approveState;
    }

    public ExpenseVO(Double money, EmployeeVO employeeVO, String efaddr, String econtent, ApproveState approveState) {
        this.money = money;
        this.employeeVO = employeeVO;
        this.efaddr = efaddr;
        this.econtent = econtent;
        this.approveState = approveState;
    }

    @Override
    public String toString() {
        return "ExpenseVO{" +
                "exid=" + exid +
                ", money=" + money +
                ", employeeVO=" + employeeVO +
                ", efaddr='" + efaddr + '\'' +
                ", econtent='" + econtent + '\'' +
                ", approveState=" + approveState +
                '}';
    }

    public ExpenseVO(Double money, EmployeeVO employeeVO, String efaddr, ApproveState approveState) {
        this.money = money;
        this.employeeVO = employeeVO;
        this.efaddr = efaddr;
        this.approveState = approveState;
    }

    public ExpenseVO(int exid, Double money, EmployeeVO employeeVO, String efaddr, ApproveState approveState) {
        this.exid = exid;
        this.money = money;
        this.employeeVO = employeeVO;
        this.efaddr = efaddr;
        this.approveState = approveState;
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

    public EmployeeVO getEmployeeVO() {
        return employeeVO;
    }

    public void setEmployeeVO(EmployeeVO employeeVO) {
        this.employeeVO = employeeVO;
    }

    public String getEfaddr() {
        return efaddr;
    }

    public void setEfaddr(String efaddr) {
        this.efaddr = efaddr;
    }

    public ApproveState getApproveState() {
        return approveState;
    }

    public void setApproveState(ApproveState approveState) {
        this.approveState = approveState;
    }
}
