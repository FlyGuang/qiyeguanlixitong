package com.hs.web;

import com.hs.po.PContract;
import com.hs.po.Project;
import com.hs.service.EmployeeService;
import com.hs.service.PContractService;
import com.hs.service.PcStateService;
import com.hs.service.ProjectService;
import com.hs.util.DateTimeFormat;
import com.hs.util.UploadFile;
import com.hs.vo.AccountVO;
import com.hs.vo.EmployeeVO;
import com.hs.vo.PContractVO;
import com.hs.vo.ProjectVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bilie
 * 项目控制器
 */
@Controller
public class ProjectController {

    Logger logger = Logger.getLogger(ProjectController.class);
    @Autowired
    ProjectService projectService;
    @Autowired
    PContractService pContractService;
    @Autowired
    PcStateService pcStateService;
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/rad/toaddproject")
    public String toaddproject(HttpSession session){
        logger.info("去项目立项页面");

        return "addproject";
    }

    @RequestMapping("rad/addproject")
    public String addproject(HttpSession session,@ModelAttribute("project") Project project){
        AccountVO accountVO=(AccountVO)session.getAttribute("currentUser");
        logger.info(project);
        logger.info(projectService.add(project));
        return "redirect:/rad/toprojectlist.action?type=2&eid="+accountVO.getEmployeeVO().getEid();
    }

    @RequestMapping("rad/toprojectlist")
    public String toprojectlist(int eid,int type,Model model){
        logger.info("去展示项目列表页面");
        List<ProjectVO> list = new ArrayList<>();
        if(type==1) {
           list= projectService.findVOAll();
        }else if (type==2){
            list=projectService.findVOByEid(eid);
        }else if (type==3){
            list=projectService.findVOByAsid(1);
        }else if (type==4){
            list=projectService.findVOByAsid(2);
        }else if (type==5){
            list=projectService.findVOByAsid(3);
        }
        model.addAttribute("list",list);
        return "projectlist";
    }


    @RequestMapping("rad/touploadpcontract")
    public  String touploadpcontract(int pid, Model model ){
        logger.info("进入touploadpcontract控制器。。。");
        logger.info(pid);
        ProjectVO projectVO =projectService.findVOByPid(pid);
        logger.info(projectVO);
        model.addAttribute("projectVO",projectVO);
        return "uploadpcontract";
    }
    @RequestMapping("rad/uploadpcontract")
    public  String uploadpcontract(@ModelAttribute("pContract") PContract pContract, String pcstart1, String pcstop2, Model model, @RequestParam("file") CommonsMultipartFile files){
        logger.info("进入uploadpcontract控制器。。。");
        logger.info(files.getOriginalFilename());
        logger.info(pContract);
        logger.info(pcstart1);
        logger.info(pcstop2);
        ProjectVO projectVO =projectService.findVOByPid(pContract.getPid());
        logger.info(projectVO);
        model.addAttribute("projectVO",projectVO);
        if(pContract.getPcid()==""||pContract.getPcid()==null) {
            model.addAttribute("mess","请输入合法的合同编号！");
            return "uploadpcontract";
        }
        if (pContractService.findByPcid(pContract.getPcid())!=null){
            model.addAttribute("mess","此合同编号已存在！");
            return "uploadpcontract";
        }

        pContract.setPcstart(DateTimeFormat.dateTime_Lacal(pcstart1));
        pContract.setPcstop(DateTimeFormat.dateTime_Lacal(pcstop2));
        if (UploadFile.checkPdf(files.getOriginalFilename())){
            String pcaddr= UploadFile.uploadfile(files);
            pContract.setPcaddr(pcaddr);
            logger.info(pcaddr);
            logger.info(pContract);
            pContractService.add(pContract);
            return "redirect:/rad/topcontractlist.action?type=1&pid="+pContract.getPid();
        }else{
            model.addAttribute("mess2","文件格式错误，请重新上传！");
            return "uploadpcontract";
        }
    }
    @RequestMapping("/rad/topcontractlist")
    public String topcontractlist(int type, int pid,String partner,Model model){
        logger.info("进入pcontractlist。。。");
        logger.info(pid);
        int state=0;
        List<PContractVO> list=new ArrayList<>();
       if (type==1){
           state=1;
           list=pContractService.findVOAll();
       } else if (type==2){
           state=2;
           list=pContractService.findVOByPid(pid);
       }else if (type==3){
           state=1;
           list=pContractService.findVOByPartner(partner);
       }

        System.out.println(list);
        for (PContractVO pContractVO:list){
            if (pContractVO.getPcstate().getPcsid()!=4){
                if (System.currentTimeMillis()>pContractVO.getPcstop().getTime()){
                    PContract pContract=pContractService.findById(pContractVO.getId());
                    pContract.setPcsid(3);
                    pContractService.update(pContract);
                }
            }
        }
        ProjectVO projectVO =projectService.findVOByPid(pid);
        logger.info(projectVO);
        model.addAttribute("projectVO",projectVO);
        model.addAttribute("list",list);
        model.addAttribute("state",state);
        return "pcontractlist";
    }
    @RequestMapping("rad/toeditpcontract")
    public  String toeditpcontract(String pcid, Model model ){
        logger.info("进入toeditpcontract控制器。。。");
        logger.info(pcid);
        PContractVO pContractVO =pContractService.findVOByPcid(pcid);
        logger.info(pContractVO);
        logger.info(pContractVO.getPcstate().getPcsid());
        model.addAttribute("pcontractVO",pContractVO);
        return "editpcontract";
    }
    @RequestMapping("rad/editpcontract")
    public  String editpcontract(@ModelAttribute("pContract") PContract pContract,int pcstateid, String pcstart1, String pcstop2, Model model){
        logger.info("进入editpcontract控制器。。。");
        logger.info(pContract);
        logger.info(pcstart1);
        logger.info(pcstop2);
        ProjectVO projectVO =projectService.findVOByPid(pContract.getPid());
        logger.info(projectVO);
        PContract pContract1=pContractService.findById(pContract.getId());
        model.addAttribute("projectVO",projectVO);
        if (pContractService.findByPcid(pContract.getPcid())!=null&&!pContract.getPcid().equals(pContract1.getPcid())){
            model.addAttribute("mess","此合同编号已存在！");
            return "uploadpcontract";
        }
        if(pContract.getPcid()==""||pContract.getPcid()==null) {
            model.addAttribute("mess","请输入合法的合同编号！");
            return "uploadpcontract";
        }
        pContract1.setPcsid(pcstateid);
        pContract1.setPcid(pContract.getPcid());
        pContract1.setPartner(pContract.getPartner());
        pContract1.setPcstart(DateTimeFormat.dateTime_Lacal(pcstart1));
        pContract1.setPcstop(DateTimeFormat.dateTime_Lacal(pcstop2));
        logger.info(pContract1);
        pContractService.update(pContract1);
        return "redirect:/rad/topcontractlist.action?type=1&pid="+pContract.getPid();
    }
    @RequestMapping("selectpcid1")
    @ResponseBody
    public boolean selectpcid1(String pcid,int id){
        logger.info("selectpcid1。。。");
        PContract pContract=pContractService.findById(id);
        logger.info(pContract);
        return pContractService.findByPcid(pcid)==null&&!pContract.getPcid().equals(pContract.getPcid())?true:false;
    }
    @RequestMapping("selectpcid")
    @ResponseBody
    public boolean selectpcid(String pcid){
        logger.info("selectpcid。。。");
        return pContractService.findByPcid(pcid)==null?true:false;
    }

    @RequestMapping("rad/toupdateproject")
    public String toupdateproject(Model model,int pid){
        logger.info("toupdateproject...");
        model.addAttribute("project",projectService.findVOByPid(pid));
        List<EmployeeVO> list=employeeService.findByRid(5);
        model.addAttribute("list",list);
        logger.info(list);
        return "updateproject";
    }
    @RequestMapping("rad/updateproject")
    public String updateproject(Project project){
        logger.info("updateproject...");
        logger.info(project);
        Project project1=projectService.findByPid(project.getPid());
        project1.setEid(project.getEid());
        projectService.update(project1);
        logger.info(project1);
        return "redirect:/rad/toprojectlist.action?type=1&eid=0";
    }
    @RequestMapping("rad/toprojectinfo")
    public  String toprojectinfo(int pid,Model model){
        logger.info("toprojectinfo....");
        model.addAttribute("project",projectService.findVOByPid(pid));
        return "projectinfo";
    }
    @RequestMapping("leader/toapproveproject")
    public String toapproveproject(int pid,int asid){
        Project project=projectService.findByPid(pid);
        project.setAsid(asid);
        projectService.update(project);
        return "redirect:/rad/toprojectlist.action?type=1&eid=0";
    }

    @RequestMapping("rad/toeditprogress")
    public String toeditpprogress( int pid,Model model){
        logger.info("进入去修改进度。。。");
        model.addAttribute("project",projectService.findVOByPid(pid));
        return "editprogress";
    }
    @RequestMapping("rad/editprogress")
    public String editprogress(Project project){
        logger.info("editprogress...");
        logger.info(project);
        Project project1=projectService.findByPid(project.getPid());
        project1.setPpid(project.getPpid());
        projectService.update(project1);
        logger.info(project1);
        return "redirect:/rad/toprojectlist.action?type=1&eid=0";
    }

}
