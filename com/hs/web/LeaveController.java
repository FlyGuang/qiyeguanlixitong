package com.hs.web;

import com.hs.po.Employee;
import com.hs.po.Leave;
import com.hs.po.LeaveType;
import com.hs.po.Project;
import com.hs.service.EmployeeService;
import com.hs.service.LeaveService;
import com.hs.service.LeaveTypeService;
import com.hs.util.DateTimeFormat;
import com.hs.vo.EmployeeVO;
import com.hs.vo.LeaveVO;
import com.hs.vo.ProjectVO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jpc
 * @author km
 * 请假控制器
 */
@Controller
public class LeaveController {
    Logger logger = Logger.getLogger(LeaveController.class);
    @Autowired
    LeaveService leaveService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    LeaveTypeService leaveTypeService;

    @RequestMapping("employee/toaddleave")
    public String toaddleave(Model model) {
        logger.info("进入新增请假控制器");
        List<EmployeeVO> employeeVOS=employeeService.findAll();
        List<LeaveType> leaveTypes=leaveTypeService.findAll();
        logger.info(leaveTypes);
        model.addAttribute("leavetype",leaveTypes);
        return "addleave";
    }

    @RequestMapping("employee/addleave")
    public String addapproveleave(Leave leave,String start1,String end1) {
        logger.info("进入请假控制器");
        logger.info(leave.getReason());
        leave.setStart(DateTimeFormat.dateTime_Lacal(start1));
        leave.setEnd(DateTimeFormat.dateTime_Lacal(end1));
        logger.info(leave.getLtid());
        logger.info(leave.getEid());
        logger.info(leave.getAsid());
        boolean flag = leaveService.add(leave);
        logger.info(flag);
        return "redirect:/employee/toleavelist.action?type=2&eid="+leave.getEid();

    }

    @RequestMapping("employee/toleavelist")
    public String toleavelist(int type,int eid,Model model) {
        logger.info("进入请假列表控制器..");
        List<LeaveVO> list = new ArrayList<>();
        if(type==1) {
            list= leaveService.findVOAll();
        }else if (type==2){
            list=leaveService.findVOByEid(eid);
        }else if (type==3){
            list=leaveService.findVOByAsid(1);
        }else if (type==4){
            list=leaveService.findVOByAsid(2);
        }else if (type==5){
            list=leaveService.findVOByAsid(3);
        }
        logger.info(list);
        model.addAttribute("list", list);
        return "leavelist";
    }

    @RequestMapping("employee/leaveinfo")
    public String leaveinfo(int lid, Model model) {
        logger.info("进入请假详情控制器");
        LeaveVO leave = leaveService.findVOById(lid);
        logger.info(leave);
        model.addAttribute("leave", leave);
        return "leaveinfo";
    }
    @RequestMapping("leader/toapproveleave")
    public String toapproveleave(int lid, int asid) {
        Leave leave=leaveService.findById(lid);
        leave.setAsid(asid);
        leaveService.update(leave);
        return "redirect:/employee/toleavelist.action?type=1&eid=0";
    }
    @RequestMapping("employee/deleteleave")
    public String deleteleave(int lid){
        Leave leave=leaveService.findById(lid);
        leaveService.delete(lid);
        return "redirect:/employee/toleavelist.action?type=2&eid="+leave.getEid();
    }
    @RequestMapping("employee/editleave")
    public String editleave(int lid) {
        Leave leave=leaveService.findById(lid);
        leave.setLstate("已销假");
        leaveService.update(leave);
        return "redirect:/employee/toleavelist.action?type=2&eid="+leave.getEid();
    }
}
