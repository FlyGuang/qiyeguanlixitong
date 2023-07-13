package com.hs.web;


import com.hs.po.Expense;
import com.hs.po.Leave;
import com.hs.po.LeaveType;
import com.hs.service.ExpenseService;
import com.hs.util.UploadFile;
import com.hs.vo.EmployeeVO;
import com.hs.vo.ExpenseVO;
import com.hs.vo.LeaveVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jpc
 * @author km
 * 报销控制器
 */
@Controller
public class ExpenseController {
    Logger logger = Logger.getLogger(ExpenseController.class);
    @Autowired
    ExpenseService expenseService;

    @RequestMapping("employee/toexpenselist")
    public String toexpenselist(int type,int eid, Model model) {
        logger.info("进入了报销列表控制器");
        //调用方法查询所有报销信息
        List<ExpenseVO> list =new ArrayList<>();
        if(type==1) {
            list= expenseService.findVOAll();
        }else if (type==2){
            list=expenseService.findVOByEid(eid);
        }else if (type==3){
            list=expenseService.findVOByAsid(1);
        }else if (type==4){
            list=expenseService.findVOByAsid(2);
        }else if (type==5){
            list=expenseService.findVOByAsid(3);
        }
        logger.info(list);
        //将查询结果放进作用域中
        model.addAttribute("list", list);
        return "expenselist";
    }

    @RequestMapping("employee/toaddexpense")
    public String toaddexpense(Model model) {
        logger.info("进入了去报销控制器。。。");
        return "addexpense";
    }
    @RequestMapping("employee/addexpense")
    public String addexpense(@RequestParam("file") CommonsMultipartFile file, @ModelAttribute("expense") Expense expense) {
        logger.info("进入报销添加....");
        logger.info(file.getOriginalFilename());
        logger.info(expense.getMoney());
        logger.info(expense.getEid());
        logger.info(expense.getEfaddr());
        logger.info(expense.getAsid());
        logger.info(expense.getEcontent());
        expense.setEfaddr(UploadFile.uploadfile(file));
        logger.info(expense);
        boolean flag = expenseService.add(expense);
        logger.info(flag);
        return "redirect:/employee/toexpenselist.action?type=2&eid="+expense.getEid();
    }
    @RequestMapping("employee/expenseinfo")
    public String expenseinfo(int exid,Model model){
        logger.info("进入报销详情控制器");
        ExpenseVO  expenseVO = expenseService.findVOByExid(exid);
        logger.info(expenseVO);
        model.addAttribute("expenseVO", expenseVO);
        return "expenseinfo";
    }

    @RequestMapping("leader/toapproveexpense")
    public String toapproveexpense(int asid,int exid) {

        logger.info(asid);
        logger.info(exid);
        Expense expense = expenseService.findByExid(exid);
        logger.info(expense);
        expense.setAsid(asid);
        expenseService.update(expense);
        return "redirect:/employee/toexpenselist.action?type=1&eid=0";
    }

    @RequestMapping("employee/deleteexpense")
    public String deleteleave(int exid){
        ExpenseVO expenseVO=expenseService.findVOByExid(exid);
        expenseService.delete(exid);
        return "redirect:/employee/toexpenselist.action?type=2&eid="+expenseVO.getEmployeeVO().getEid();
    }
}
