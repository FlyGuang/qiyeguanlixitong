package com.hs.web;


import com.hs.po.Account;
import com.hs.po.Meeting;
import com.hs.po.Message;
import com.hs.service.*;
import com.hs.util.Captcha;
import com.hs.vo.AccountVO;
import com.hs.vo.EmployeeVO;
import com.hs.vo.ProjectVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    //创建日志
    Logger logger = Logger.getLogger(IndexController.class);

    @Autowired
    AccountService accountService;

    @Autowired
    ProjectService projectService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    MeetingService meetingService;

    @Autowired
    MessageService messageService;


    /**
     * 主页控制器
     * @return
     */
    @RequestMapping("/index.action")
    public String list(){
        logger.info("进入了index控制器");
        return "index";
    }

    /**
     * 前往登录界面控制器
     * @return
     */
    @RequestMapping("/tologin")
    public String tologin() {
        logger.info("去登陆页面");
        return "login";
    }
    /**
     * 登录控制器
     * @param name
     * @param pass
     * @param session
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(String name, String pass, HttpSession session, HttpServletRequest request,Model model) {
        logger.info("进入login action...........");
        logger.info(name);
        if (name.length() >= 7) {
            AccountVO account = accountService.findByEid(employeeService.findByTel(name).getEid());
            if (account != null && account.getPass().equals(pass)) {
                session.setAttribute("currentUser",account);
                return "redirect:/main.action";
            } else {
                request.setAttribute("mess","账号或密码有误");
                return "login";
            }
        }else {
            int aid = Integer.valueOf(name);
            AccountVO accountVO = accountService.findByAidAndPass(aid,pass);
            if (accountVO!=null) {
                session.setAttribute("currentUser",accountVO);

                return "redirect:/main.action";
            }else {
                request.setAttribute("mess","账号或密码有误");
                return "login";
            }
        }
    }


    /**
     * 进入主页面控制器
     * @param model
     * @return
     */
    @RequestMapping("/main.action")
    public String main(Model model,HttpSession session){
        logger.info("进入main action............");
        Integer pnum = projectService.count();
        Integer enum1 = projectService.countWait();
        Integer enum2 = employeeService.countworking();
        List<EmployeeVO> list = employeeService.findNotlizhi();
        List<ProjectVO> list1 = projectService.findVOPass();
        List<ProjectVO> list2 = projectService.finVOWait();
        logger.info(pnum);
        logger.info(enum1);
        logger.info(enum2);
        logger.info(list);
        logger.info(list1);
        model.addAttribute("pnum",pnum);
        model.addAttribute("enum1",enum1);
        model.addAttribute("enum2",enum2);
        model.addAttribute("list",list);
        model.addAttribute("list1",list1);
        model.addAttribute("list2",list2);
        return "main";
    }

    @RequestMapping("/captcaha.action")
    public void captcaha(HttpServletRequest request, HttpServletResponse response){
        try {
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            response.setHeader("Pragma", "no-cache");
            response.setContentType("image/jpeg");
            HttpSession session = request.getSession();
            OutputStream os = response.getOutputStream();
            // 返回验证码和图片的map
            Map<String, Object> map = Captcha.getImageCode(86, 37, os);
            String simpleCaptcha = "simpleCaptcha";
            session.setAttribute(simpleCaptcha, map.get("strEnsure").toString().toLowerCase());
            session.setAttribute("codeTime", new Date().getTime());
            ImageIO.write((BufferedImage) map.get("image"), "jpg", os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取体验账号控制器
     * @param type
     * @return
     */
    @RequestMapping("/getaccount")
    @ResponseBody
    public Account getaccount(int type){
        logger.info(type);
        Account account = null;
        if (type==1){
            account = accountService.findByAid(10001);
        }else if (type==2){
            account = accountService.findByAid(10003);
        }else if (type==3){
            account = accountService.findByAid(10002);
        }else if (type==4){
            account = accountService.findByAid(10004);
        }else if (type==5){
            account = accountService.findByAid(10005);
        }else if (type==6){
            account = accountService.findByAid(10009);
        }
        return  account;
    }

    @RequestMapping("getmessage")
    @ResponseBody
    public boolean getmessage(@RequestBody Message message){

        return messageService.add(message);
    }

    @RequestMapping("leader/messageinfo")
    public String messageinfo(int id,Model model){
        Message message = messageService.findById(id);
        model.addAttribute("message",message);
        return "messageinfo";
    }

    @RequestMapping("leader/messagelist")
    public String messagelist(int type, Model model){
        List<Message> list = messageService.findAll();
        if (type==1){
            model.addAttribute("list",list);
        }else if (type==2){
            List<Message> messages = new ArrayList<>();
            for (Message message:list){
                if (message.getFeedback().equals("已反馈")){
                    messages.add(message);
                    model.addAttribute("list",messages);
                }
            }
        }else if (type==3){
            List<Message> messages = new ArrayList<>();
            for (Message message:list){
                if (message.getFeedback().equals("未反馈")){
                    messages.add(message);
                    model.addAttribute("list",messages);
                }
            }
        }
        return "messagelist";
    }

    @RequestMapping("leader/feedback")
    public String feedback(int id){
        Message message = messageService.findById(id);
        message.setFeedback("已反馈");
        messageService.update(message);
        return "redirect:/leader/messagelist.action?type=1";
    }

}