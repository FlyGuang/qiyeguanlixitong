package com.hs.interceptor;

import com.hs.po.Account;
import com.hs.po.Employee;
import com.hs.po.Meeting;
import com.hs.po.Message;
import com.hs.service.*;
import com.hs.service.impl.AccountServiceImpl;
import com.hs.service.impl.EmployeeServiceImpl;
import com.hs.vo.AccountVO;
import com.hs.vo.ExpenseVO;
import com.hs.vo.LeaveVO;
import com.hs.vo.ProjectVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author bilie
 * 消息通知拦截器
 */
public class NoticeInterceptor implements HandlerInterceptor {

    Logger logger = Logger.getLogger(NoticeInterceptor.class);

    @Autowired
    MeetingService meetingService;

    @Autowired
    LeaveService leaveService;

    @Autowired
    ProjectService projectService;

    @Autowired
    ExpenseService expenseService;

    @Autowired
    MessageService messageService;
    @Autowired
    AccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("进入所有控制器的拦截器");
        HttpSession session = httpServletRequest.getSession();
        List<Meeting> meetings = new ArrayList<>();
        List<Meeting> list3 = meetingService.findAllAsc();
        Object obj = session.getAttribute("currentUser");
        if (obj != null) {
            AccountVO accountVO = (AccountVO) obj;
            for (AccountVO account11:accountService.findVOAll()){
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

            for (Meeting meeting : list3) {
                if (meeting.getMeetingstate().equals("未开始") && meeting.getMeetingstart().getTime() < (new Date().getTime() + 86400000)) {
                    if (meeting.getDid() == accountVO.getEmployeeVO().getDept().getDid() || accountVO.getEmployeeVO().getRole().getRid() == 3) {
                        meetings.add(meeting);
                    }
                }
            }
            int meetingnum = meetings.size();
            session.setAttribute("meetingnum", meetingnum);
            session.setAttribute("meetings", meetings);

            List<LeaveVO> leaveVOList = new ArrayList<>();
            List<LeaveVO> leaveVOS = leaveService.findVOAll();
            for (LeaveVO leaveVO : leaveVOS) {
                if (leaveVO.getApprovestate().getAsid() == 1) {
                    if (((accountVO.getEmployeeVO().getDept().getDid() == leaveVO.getEmployeeVO().getDept().getDid()) && accountVO.getEmployeeVO().getRole().getRid() == 4) || accountVO.getEmployeeVO().getRole().getRid() == 3) {
                        leaveVOList.add(leaveVO);
                    }
                }
            }
            int leavenum = leaveVOList.size();
            session.setAttribute("leavenum", leavenum);

            List<ProjectVO> projectVOList = new ArrayList<>();
            List<ProjectVO> projectVOS = projectService.findVOAll();
            for (ProjectVO projectVO : projectVOS) {
                if (projectVO.getApprovestate().getAsid() == 1) {
                    if (((accountVO.getEmployeeVO().getDept().getDid() == projectVO.getEmployeeVO().getDept().getDid()) && accountVO.getEmployeeVO().getRole().getRid() == 4) || accountVO.getEmployeeVO().getRole().getRid() == 3) {
                        projectVOList.add(projectVO);
                    }
                }
            }
            int projectnum = projectVOList.size();
            session.setAttribute("projectnum", projectnum);


            List<ExpenseVO> expenseVOList = new ArrayList<>();
            List<ExpenseVO> expenseVOS = expenseService.findVOAll();
            for (ExpenseVO expenseVO : expenseVOS) {
                if (expenseVO.getApproveState().getAsid() == 1) {
                    if (((accountVO.getEmployeeVO().getDept().getDid() == expenseVO.getEmployeeVO().getDept().getDid()) && accountVO.getEmployeeVO().getRole().getRid() == 4) || accountVO.getEmployeeVO().getRole().getRid() == 3) {
                        expenseVOList.add(expenseVO);
                    }
                }
            }
            int expensenum = expenseVOList.size();
            session.setAttribute("expensenum", expensenum);

            int num = leavenum + projectnum + expensenum;
            session.setAttribute("num", num);

            List<Message> messagelist = new ArrayList<>();
            List<Message> messages1 = messageService.findAll();
            for (Message message : messages1) {
                if (message.getFeedback().equals("未反馈")) {
                    messagelist.add(message);
                }
            }
            int messagenum = messagelist.size();
            session.setAttribute("messagenum", messagenum);
            session.setAttribute("messagelist",messagelist);

        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
