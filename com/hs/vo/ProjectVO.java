package com.hs.vo;

import com.hs.po.ApproveState;
import com.hs.po.Dept;
import com.hs.po.PProgress;

import java.sql.Timestamp;

/**
 * @author km
 * 项目立项视图类
 */
public class ProjectVO {

    /**
     * 项目编号
     */
    private int pid;

    /**
     * 项目名称
     */
    private String pname;

    /**
     * 项目内容
     */
    private String pcontent;

    /**
     * 项目负责人
     */
    private EmployeeVO employeeVO;

    /**
     * 项目立项时间
     */
    private Timestamp pcreatetime;

    /**
     * 项目审批状态
     */
    private ApproveState approvestate;

    /**
     * 项目进度
     */
    private PProgress pprogress;


    public ProjectVO(String pname, String pcontent, EmployeeVO employeeVO, Timestamp pcreatetime, ApproveState approvestate, PProgress pprogress) {
        this.pname = pname;
        this.pcontent = pcontent;
        this.employeeVO = employeeVO;
        this.pcreatetime = pcreatetime;
        this.approvestate = approvestate;
        this.pprogress = pprogress;
    }

    @Override
    public String toString() {
        return "ProjectVO{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pcontent='" + pcontent + '\'' +
                ", employeeVO=" + employeeVO +
                ", pcreatetime=" + pcreatetime +
                ", approvestate=" + approvestate +
                ", pprogress=" + pprogress +
                '}';
    }

    public ProjectVO(int pid, String pname, String pcontent, EmployeeVO employeeVO, Timestamp pcreatetime, ApproveState approvestate, PProgress pprogress) {
        this.pid = pid;
        this.pname = pname;
        this.pcontent = pcontent;
        this.employeeVO = employeeVO;
        this.pcreatetime = pcreatetime;
        this.approvestate = approvestate;
        this.pprogress = pprogress;
    }

    public ProjectVO() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public EmployeeVO getEmployeeVO() {
        return employeeVO;
    }

    public void setEmployeeVO(EmployeeVO employeeVO) {
        this.employeeVO = employeeVO;
    }

    public Timestamp getPcreatetime() {
        return pcreatetime;
    }

    public void setPcreatetime(Timestamp pcreatetime) {
        this.pcreatetime = pcreatetime;
    }

    public ApproveState getApprovestate() {
        return approvestate;
    }

    public void setApprovestate(ApproveState approvestate) {
        this.approvestate = approvestate;
    }

    public PProgress getPprogress() {
        return pprogress;
    }

    public void setPprogress(PProgress pprogress) {
        this.pprogress = pprogress;
    }

}
