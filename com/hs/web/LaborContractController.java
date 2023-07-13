package com.hs.web;

import com.hs.po.Employee;
import com.hs.po.LaborContract;
import com.hs.po.LcState;
import com.hs.po.PContract;
import com.hs.service.EmployeeService;
import com.hs.service.LaborContractService;
import com.hs.service.LcStateService;
import com.hs.util.DateTimeFormat;
import com.hs.util.UploadFile;
import com.hs.vo.EmployeeVO;
import com.hs.vo.LaborContractVO;
import com.hs.vo.ProjectVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author awei
 * 劳动合同控制器
 */
@RequestMapping("personnel")
@Controller
public class LaborContractController {

    Logger logger=Logger.getLogger(LaborContractController.class);
    @Autowired
    LaborContractService laborContractService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    LcStateService lcStateService;

    @RequestMapping("/tolaborcontractlist")
    public String tolaborcontractlist(Model model,int type,int eid){
        logger.info("进入到劳动合同列表");
        List<LaborContractVO> list=new ArrayList<>();
        int state=0;
        if (type==1){
            state=1;
            list=laborContractService.findAllVO();
        }else if (type==2){
            state=2;
            list=laborContractService.findVOByEid(eid);
        }

        for (LaborContractVO laborContractVO:list){
            if (employeeService.findByEid1(laborContractVO.getEid()).getEsid()==3){
                laborContractService.findByLcid(laborContractVO.getLcid()).setLcsid(3);
            }else if(System.currentTimeMillis()>laborContractVO.getLcstop().getTime()){
                laborContractService.findByLcid(laborContractVO.getLcid()).setLcsid(2);
            }
        }
        logger.info(list);
        model.addAttribute("state",state);
        model.addAttribute("list",list);
        model.addAttribute("employee",employeeService.findByEid1(eid));
        return "laborcontractlist";
    }
    @RequestMapping("/toaddlc")
    public String toaddlc(Model model,int eid) {
        logger.info("去添加合同");
        List<EmployeeVO> list=employeeService.findAll();
        logger.info(list);
        model.addAttribute("list",list);
        model.addAttribute("employee",employeeService.findByEid1(eid));
        return "addlc";
    }

    @RequestMapping("/addlc")
    public String addlc(Model model,@ModelAttribute("laborContract") LaborContract laborContract, @RequestParam("file")CommonsMultipartFile file, String lcstart1, String lcstop1) {
        logger.info(file.getOriginalFilename());
        logger.info(laborContract);
        logger.info(lcstart1);
        logger.info(lcstop1);
        EmployeeVO employeeVO =employeeService.findVOByEid(laborContract.getEid());
        logger.info(employeeVO);
        model.addAttribute("employee",employeeVO);
        if(laborContract.getLcid()==""||laborContract.getLcid()==null) {
            model.addAttribute("mess","请输入合法的合同编号！");
            return "addlc";
        }
        if (laborContractService.findByLcid(laborContract.getLcid())!=null){
            model.addAttribute("mess","此合同编号已存在！");
            return "addlc";
        }

        laborContract.setLcstart(DateTimeFormat.dateTime_Lacal(lcstart1));
        laborContract.setLcstop(DateTimeFormat.dateTime_Lacal(lcstop1));
        if (UploadFile.checkPdf(file.getOriginalFilename())){
            String lcaddr= UploadFile.uploadfile(file);
            laborContract.setLcaddr(lcaddr);
            logger.info(lcaddr);
            logger.info(laborContract);
            laborContractService.add(laborContract);
            return "redirect:/personnel/tolaborcontractlist.action?type=1&eid=0";
        }else{
            model.addAttribute("mess2","文件格式错误，请重新上传！");
            return "addlc";
        }
    }
    @RequestMapping("/toeditlc")
    public String toeditlc(String lcid, Model model){
        logger.info("去修改");
        LaborContractVO laborContract = laborContractService.findVOByLcid(lcid);
        model.addAttribute("laborContract",laborContract);
        return "editlc";
    }
    @RequestMapping("/editlc")
    public String editlc(String lcid,int lcsid){
        logger.info("进入编辑合同控制器");
        logger.info(lcid);
        LaborContract laborContract=laborContractService.findByLcid(lcid);
        laborContract.setLcsid(lcsid);
        logger.info(laborContract);
        laborContractService.update(laborContract);
        return "redirect:/personnel/tolaborcontractlist.action?type=1&eid=0";
    }
    @RequestMapping("toselectlc")
    public String toselectlc(Model model){
        logger.info("进入到查找合同控制器");
        List<LcState> list=lcStateService.findAll();
        model.addAttribute("list",list);
        return "selectlc";
    }
    @RequestMapping("selectlc")
    public String selectLc(int lcsid,Model model){
        logger.info("已进入");
        logger.info(lcsid);
        List<LaborContractVO> list=laborContractService.findVOByLcsid(lcsid);
        model.addAttribute("list",list);
        return "laborcontractlist";
    }
    @RequestMapping("deletelc")
    public String deletelc(){
        logger.info("删除劳动合同");
        return "redirect:/personnel/tolaborcontractlist.action?type=1&eid=0";
    }

    @RequestMapping("selectlcid")
    @ResponseBody
    public boolean selectlcid(String lcid){
        logger.info("selectlcid。。。");
        return laborContractService.findByLcid(lcid)==null?true:false;
    }

}
