package com.hs.web;

import com.hs.po.Project;
import com.hs.po.Scheme;
import com.hs.service.PProgressService;
import com.hs.service.ProjectService;
import com.hs.service.SchemeService;
import com.hs.vo.Progress;
import com.hs.vo.SchemeVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author bilie
 * 方案进度的控制器
 */
@RequestMapping("rad")
@Controller
public class SchemeController {

    Logger logger = Logger.getLogger(SchemeController.class);

    @Autowired
    SchemeService schemeService;

    @Autowired
    ProjectService projectService;

    @Autowired
    PProgressService progressService;

    @RequestMapping("/toschemelist")
    public String toschemelist(Model model){
        logger.info("去方案列表页面");
        List<SchemeVO> list = schemeService.findVOAll();
        logger.info(list);
        model.addAttribute("list",list);
        return "schemelist";
    }

    @RequestMapping("/toaddscheme")
    public String toaddscheme(Model model){
        logger.info("去添加方案页面");
        List<Project> list = projectService.findAll();
        logger.info(list);
        model.addAttribute("list",list);
        return "addscheme";
    }

    @RequestMapping("/addscheme")
    public String addscheme(Scheme scheme){
        logger.info("添加方案");
        schemeService.add(scheme);
        return "redirect:/rad/toschemelist.action";
    }

    @RequestMapping("/toprogress")
    public String toprogress(){
        logger.info("展示项目进度");
        return "progress";
    }

    @RequestMapping("/toshow")
    @ResponseBody
    public Map toshow(Model model){
        logger.info("进入展示统计图控制器");
        Map map = progressService.toshow();
        model.addAttribute("map",map);
        return map;
    }
    @RequestMapping("toeditscheme")
    public String toEditScheme(int scid,Model model){
        logger.info("去修改方案");
        SchemeVO scheme=schemeService.findByScidVO(scid);
        model.addAttribute("scheme",scheme);
        return "editscheme";
    }
    @RequestMapping("editscheme")
    public String editScheme(int scid, String sctitle,String scontent){
        logger.info("开始修改方案");
        Scheme scheme= schemeService.findByScid(scid);
        scheme.setSctitle(sctitle);
        scheme.setScontent(scontent);
        schemeService.update(scheme);
        return "redirect:/rad/toschemelist.action";
    }


}
