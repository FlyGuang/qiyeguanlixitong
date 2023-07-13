package com.hs.web;

import com.hs.po.Account;
import com.hs.po.Employee;
import com.hs.service.AccountService;
import com.hs.service.EmployeeService;
import com.hs.vo.AccountVO;
import com.hs.vo.EmployeeVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ss
 * 账号控制器
 */
@RequestMapping("personnel")
@Controller
public class AccountController {

    Logger logger = Logger.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/accountlist")
    public String accountlist(Model model){
        logger.info("进入accountlist action..............");
        List<AccountVO> list = accountService.findVOAll();
        for (AccountVO account11:list){
            Account accountnew=accountService.findByAid(account11.getAid());
            if (account11.getEmployeeVO().getEstate().getEsid()==3){
                accountnew.setAstate("未启用");
                logger.info(accountnew);
                accountService.update(accountnew);
            }else{
                accountnew.setAstate("已启用");
                logger.info(accountnew);
                accountService.update(accountnew);
            }
        }
        logger.info(list);
        model.addAttribute("list",list);
        return "accountlist";
    }

    @RequestMapping("/toaddaccount")
    public String toaddaccount(Model model){
        logger.info("去添加账号页面");
        List<EmployeeVO> list = new ArrayList<>();
        List<EmployeeVO> employees = employeeService.findAll();
        for (EmployeeVO employeeVO:employees){
            if (accountService.findByEid(employeeVO.getEid())==null){
                list.add(employeeVO);
            }
        }
        logger.info(list);
        model.addAttribute("list",list);
        return "addaccount";
    }

    @RequestMapping("/addaccount")
    public String addaccount(Account account){
        logger.info("添加账号");
        accountService.add(account);
        return "redirect:/personnel/accountlist.action";
    }

    @RequestMapping("/toallotaccount")
    public String toallotaccount(Model model){
        logger.info("去账号列表界面");
        List<EmployeeVO> list = new ArrayList<>();
        //调用方法查询所有用户
        List<EmployeeVO> employeeVOS = employeeService.findAll();
        for (EmployeeVO employeeVO:employeeVOS){
            if (accountService.findByEid(employeeVO.getEid())==null&&employeeVO.getEstate().getEsid()==1){
                list.add(employeeVO);
            }
        }
        //将查询结果装入作用域
        model.addAttribute("list",list);
        return "allotaccount";
    }



    @RequestMapping("/toallot")
    public String toallot(int eid, Model model){
        logger.info("去账号列表界面");
        List<EmployeeVO> list = new ArrayList<>();
        EmployeeVO employee = employeeService.findVOByEid(eid);
        list.add(employee);
        //将查询结果装入作用域
        model.addAttribute("list",list);
        return "addaccount";
    }

}
