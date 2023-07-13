package com.hs.vo;

import com.hs.po.ApproveState;
import com.hs.po.LeaveType;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author km
 * 请假视图类
 */
public class LeaveVO {
    /**
     * 请假编号
     */
    private int lid;
    /**
     * 请假原因
     */
    private String reason;
    /**
     * 请假开始时间
     */
    private Timestamp start;
    /**
     * 请假结束时间
     */
    private Timestamp end;
    /**
     * 请假类型
     */
    private LeaveType leavetype;
    /**
     * 员工
     */
    private EmployeeVO employeeVO;
    /**
     * 审批状态
     */
    private ApproveState approvestate;
    /**
     * 请假状态
     */
    private String lstate;

    public LeaveVO() {
    }

    public LeaveVO(int lid, String reason, Timestamp start, Timestamp end, LeaveType leavetype, EmployeeVO employeeVO, ApproveState approvestate, String lstate) {
        this.lid = lid;
        this.reason = reason;
        this.start = start;
        this.end = end;
        this.leavetype = leavetype;
        this.employeeVO = employeeVO;
        this.approvestate = approvestate;
        this.lstate = lstate;
    }

    public LeaveVO(String reason, Timestamp start, Timestamp end, LeaveType leavetype, EmployeeVO employeeVO, ApproveState approvestate, String lstate) {
        this.reason = reason;
        this.start = start;
        this.end = end;
        this.leavetype = leavetype;
        this.employeeVO = employeeVO;
        this.approvestate = approvestate;
        this.lstate = lstate;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public LeaveType getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(LeaveType leavetype) {
        this.leavetype = leavetype;
    }

    public EmployeeVO getEmployeeVO() {
        return employeeVO;
    }

    public void setEmployeeVO(EmployeeVO employeeVO) {
        this.employeeVO = employeeVO;
    }

    public ApproveState getApprovestate() {
        return approvestate;
    }

    public void setApprovestate(ApproveState approvestate) {
        this.approvestate = approvestate;
    }

    public String getLstate() {
        return lstate;
    }

    public void setLstate(String lstate) {
        this.lstate = lstate;
    }
}
