package com.hs.web;

import com.hs.po.*;
import com.hs.service.*;
import com.hs.vo.AccountVO;
import com.hs.vo.EmployeeVO;
import com.hs.vo.ProjectVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;


/**
 * @author bilie
 * 员工控制器
 */
@Controller
public class EmployeeController {

    Logger logger = Logger.getLogger(EmployeeController.class);

    @Autowired
    RoleService roleService;

    @Autowired
    DeptService deptService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AccountService accountService;

    @Autowired
    ProvinceService provinceService;

    @Autowired
    CityService cityService;

    @Autowired
    AreaService areaService;

    @Autowired
    ProjectService projectService;
    @Autowired
    EstateService estateService;


    /**
     * 用户列表控制器
     * @param model
     * @return
     */
    @RequestMapping("employee/toemployeelist")
    public String toemployeelist(Model model){
        logger.info("去用户列表界面");
        //调用方法查询所有用户
        List<EmployeeVO> list = employeeService.findAll();
        //将查询结果装入作用域
        model.addAttribute("list",list);
        return "employeelist";
    }

    /**
     * 进入修改密码界面控制器
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("employee/toupdatepass")
    public String toupdatepass(HttpSession session,HttpServletRequest request){
        Object obj = session.getAttribute("currentUser");
        AccountVO accountVO = (AccountVO) obj;
        logger.info(accountVO);
        logger.info(accountVO.getAid());
        request.setAttribute("aid",accountVO.getAid());
        logger.info("进入修改密码页面");
        return "updatepass";
    }

    /**
     * 修改账号密码控制器
     * @param aid
     * @param pass
     * @return
     */
    @RequestMapping("employee/updatepass")
    public String toupdatepass(int aid,String pass){
        logger.info("修改账号密码");
        Account account = accountService.findByAid(aid);
        account.setPass(pass);
        accountService.update(account);
        return "login";
    }

    /**
     * 退出登录控制器
     * @param session
     * @return
     */
    @RequestMapping("employee/exit")
    public String exit(HttpSession session){
        logger.info("退出登陆");
        session.invalidate();
        return "login";
    }

    /**
     * 展示员工信息控制器
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("employee/showuser")
    public String showuser(HttpSession session,HttpServletRequest request){
        Object obj = session.getAttribute("currentUser");
        AccountVO account = (AccountVO)obj;
        AccountVO accountVO = accountService.findVOByAid(account.getAid());
        request.setAttribute("account",accountVO);
        logger.info("展示员工信息");
        return "showuser";
    }


    /**
     * 前往修改员工信息界面控制器
     * @param model
     * @param eid
     * @return
     */
    @RequestMapping("employee/toedituser")
    public String toedituser(Model model,int eid){
        EmployeeVO  employee = employeeService.findVOByEid(eid);
        List<Role> rlist = roleService.findAll();
        logger.info(rlist);
        List<Dept> dlist = deptService.findAll();
        model.addAttribute("rlist",rlist);
        model.addAttribute("dlist",dlist);
        model.addAttribute("employee",employee);
        return "toedituser";
    }

    /**
     * 修改员工信息控制器
     * @param eid
     * @param sex
     * @param birthday
     * @param tel
     * @param provinceId
     * @param cityId
     * @param areaId
     * @param rid
     * @param did
     * @return
     */
    @RequestMapping("employee/edituser")
    public String edituser( int eid, String sex,Date birthday, String tel,String provinceId,String cityId,String areaId,int rid,int did){
        logger.info("修改用户信息控制单元");
        logger.info(eid);
        logger.info(sex);
        logger.info(tel);
        logger.info(birthday);
        logger.info(provinceId);
        logger.info(cityId);
        logger.info(areaId);
        Employee employee = employeeService.findByEid1(eid);
        employee.setEsex(sex);
        employee.setTel(tel);
        employee.setBirthday(birthday);
        employee.setRid(rid);
        employee.setDid(did);
        Province province = provinceService.findObject(provinceId);
        City city =cityService.findObject(cityId);
        Area area = areaService.findObject(areaId);
        String address = province.getProvince()+city.getCity()+area.getAreas();
        employee.setAddress(address);
        logger.info(employee);
        logger.info(employeeService.updataEmployee(employee));
        return "redirect:/employee/toemployeelist.action";
    }

    @RequestMapping("employee/toemployeeinfo")
    public String toemployeeinfo(int eid,Model model){
        logger.info("展示员工信息");
        EmployeeVO employeeVO = employeeService.findVOByEid(eid);
        model.addAttribute("employeeVO",employeeVO);
        return "employeeinfo";
    }

    /**
     * 前往新增员工页面控制器
     * @param model
     * @return
     */
    @RequestMapping("personnel/toaddemployee")
    public String toaddemployee(Model model){
        List<Role> roles = roleService.findAll();
        List<Dept> depts = deptService.findAll();
        model.addAttribute("roles", roles);
        model.addAttribute("depts",depts);
        return "addemployee";
    }

    /**
     * 添加员工控制器
     * @param ename
     * @param sex
     * @param birthday
     * @param tel
     * @param provinceId
     * @param cityId
     * @param areaId
     * @param rid
     * @param did
     * @param esid
     * @return
     */
    @RequestMapping("personnel/addemployee")
    public String addemployee(String ename, String sex,Date birthday, String tel,String provinceId,String cityId,String areaId,int rid,int did,int esid){
        logger.info("添加用户信息控制单元");

        logger.info(sex);
        logger.info(tel);
        logger.info(birthday);
        logger.info(provinceId);
        logger.info(cityId);
        logger.info(areaId);
        logger.info("esid="+esid);
        Employee employee = new Employee();
        employee.setEname(ename);
        employee.setEsex(sex);
        employee.setTel(tel);
        employee.setBirthday(birthday);
        employee.setRid(rid);
        employee.setDid(did);
        employee.setEsid(esid);
        Province province = provinceService.findObject(provinceId);
        City city =cityService.findObject(cityId);
        Area area = areaService.findObject(areaId);
        String address = province.getProvince()+city.getCity()+area.getAreas();
        employee.setAddress(address);
        logger.info(employee);
        logger.info(employeeService.addEmployee(employee));
        return "redirect:/employee/toemployeelist.action";
    }

    @RequestMapping("personnel/toeditestate")
    public String toeditestate(int eid,Model model){
        logger.info("toeditestate.....");
        logger.info(eid);
        model.addAttribute("employee",employeeService.findVOByEid(eid));
        model.addAttribute("estate",estateService.findAll());
        return "editestate";
    }
    @RequestMapping("personnel/editestate")
    public String editestate(Employee employee,Model model){
        logger.info("editestate.....");
        logger.info(employee);
        Employee employee1=employeeService.findByEid1(employee.getEid());
        employee1.setEsid(employee.getEsid());
        employeeService.updataEmployee(employee1);
        return "redirect:/employee/toemployeelist.action";
    }


    @RequestMapping("/checktel")
    @ResponseBody
    public boolean checktel(String tel){
        logger.info(tel);
        EmployeeVO employee=employeeService.findByTel(tel);
        logger.info(employee);
        boolean flag=(employee==null)?true:false;
        return flag;
    }
    @RequestMapping("/checkte2")
    @ResponseBody
    public boolean checkte2(String tel){
        logger.info(tel);
        EmployeeVO employee=employeeService.findByTel(tel);
        logger.info(employee);
        return (employee==null)&&employee.getTel().equals(employeeService.findByEid1(employee.getEid()))?true:false;
    }
}
