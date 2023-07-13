package com.hs.web;

import com.hs.po.Dept;
import com.hs.service.DeptService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author ss
 * 部门控制器
 */
@RequestMapping("personnel")
@Controller
public class DeptController {

    Logger logger = Logger.getLogger(DeptController.class);

    @Autowired
    DeptService deptService;

    @RequestMapping("/deptlist")
    public String deptlist(Model model){
        logger.info("进入部门列表控制器");
        List<Dept> list = deptService.findAll();
        logger.info(list);
        model.addAttribute("list",list);
        return "deptlist";
    }

    @RequestMapping("/toadddept")
    public String toadddept(){
        logger.info("进入部门添加界面");
        return "adddept";
    }

    @RequestMapping("/adddept")
    public String adddept(Dept dept, Model model){

        logger.info("进入添加部门控制器");
        if (deptService.findByDname(dept.getDname())!=null){
            model.addAttribute("mess","此部门已存在");
            return "adddept";
        }
        if (dept.getDname()==""||dept.getDname()==null){
            model.addAttribute("mess","部门名称不能为空");
            return "adddept";
        }
        deptService.addDept(dept);
        return "redirect:/personnel/deptlist.action";
    }

    @RequestMapping("/toupdatedept")
    public String toupdatedept(int did,Model model){
        model.addAttribute("dept",deptService.findByDid(did));
        model.addAttribute("dlist",deptService.findAll());
        return "updatedept";
    }

    @RequestMapping("/updatedept")
    public String updatedept(Dept dept,Model model){
        logger.info("进入修改部门控制单元");
        if (deptService.findByDname(dept.getDname())!=null&&!dept.getDname().equals(deptService.findByDid(dept.getDid()).getDname())){
            model.addAttribute("mess","该部门名称已存在");
            return "updatedept";
        }
        if (dept.getDname()==""||dept.getDname()==null){
            model.addAttribute("mess","部门名称不能为空");
            return "updatedept";
        }
        deptService.updeteDept(dept);
        return "redirect:/personnel/deptlist.action";
    }



}














