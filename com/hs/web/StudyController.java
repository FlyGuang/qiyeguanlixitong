package com.hs.web;

import com.hs.po.Study;
import com.hs.service.StudyService;
import com.hs.util.UploadFile;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * @author awei
 * 学习内容控制器
 */
@Controller
public class StudyController {

    Logger logger=Logger.getLogger(StudyController.class);

    @Autowired
    StudyService studyService;

    @RequestMapping("/employee/tostudy")
        public String tostudy(Model model){
        logger.info("去学习");
        List<Study> list= studyService.findAll();
        logger.info(list);
        model.addAttribute("list",list);
        return "study";
    }
    @RequestMapping("personnel/toaddstudy")
    public String toAddStudy(Model model){
        logger.info("准备添加学习内容");
        return "addstudy";
    }
    @RequestMapping("personnel/addstudy")
    public String addStudy(Model model,String stutitle,String stuaddr,String imgaddr,@RequestParam("file") CommonsMultipartFile file){
        logger.info("添加学习内容");
        Study study=new Study();
        study.setStutitle(stutitle);
        study.setStuaddr(stuaddr);
        if(UploadFile.checkMag(file.getOriginalFilename())){
            study.setImgaddr(UploadFile.uploadfile(file));
            boolean flag = studyService.addStudy(study);
            logger.info(flag);
            return "redirect:/employee/tostudy.action";
        }else{
            model.addAttribute("mess","图片格式错误，请重新上传！");
            return "addstudy";
        }
    }
    @RequestMapping("personnel/deletestudy")
    public String deletestudy(int stuid,Model model){
        logger.info("删除学习内容");
        boolean flag=studyService.delete(stuid);
        logger.info(flag);
        return "redirect:/employee/tostudy.action";
    }
}
