package com.hs.web;

import com.hs.po.Dept;
import com.hs.po.Meeting;
import com.hs.po.Record;
import com.hs.service.DeptService;
import com.hs.service.MeetingService;
import com.hs.service.RecordService;
import com.hs.util.DateTimeFormat;
import com.hs.vo.MeetingVO;
import com.hs.vo.RecordVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author bilie
 * 会议的控制器
 */
@Controller
public class MeetingController {

    Logger logger = Logger.getLogger(MeetingController.class);

    @Autowired
    MeetingService meetingService;

    @Autowired
    DeptService deptService;

    @Autowired
    RecordService recordService;

    @RequestMapping("employee/tomeetinglist")
    public String tomeetinglist(Model model){
        logger.info("展示会议列表");
        List<MeetingVO> list = meetingService.findVOAll();
        for (MeetingVO meetingVO : list) {
            Meeting meeting = meetingService.findByMid(meetingVO.getMid());
            if (meetingVO.getMeetingstart().getTime() < new Date().getTime() && meetingVO.getMeetingstop().getTime() > new Date().getTime()) {
                meeting.setMeetingstate("进行中");
                meetingService.update(meeting);
            } else if (meetingVO.getMeetingstop().getTime() < new Date().getTime()) {
                meeting.setMeetingstate("已结束");
                meetingService.update(meeting);
            }
        }
        logger.info(list);
        model.addAttribute("list",list);
        return "meetinglist";
    }

    @RequestMapping("manager/toaddmeeting")
    public String toaddmeeting(Model model){
        logger.info("进入添加会议界面");
        List<Dept> list = deptService.findAll();
        model.addAttribute("list",list);
        return "addmeeting";
    }

    @RequestMapping("manager/addmeeting")
    public String addmeeting(Meeting meeting,String meetingstart1,String meetingstop1){
        logger.info(meetingstart1);
        meeting.setMeetingstart(DateTimeFormat.dateTime_Lacal(meetingstart1));
        meeting.setMeetingstop(DateTimeFormat.dateTime_Lacal(meetingstop1));
        logger.info("开始添加新的会议");
        meetingService.add(meeting);
        return "redirect:/employee/tomeetinglist.action";
    }

    @RequestMapping("employee/tomeetingnotice")
    public String tomeetingnotice(Model model){
        logger.info("进入会议通知界面");
        List<MeetingVO> list = meetingService.findVOAll();
        for (MeetingVO meetingVO : list) {
            Meeting meeting = meetingService.findByMid(meetingVO.getMid());
            if (meetingVO.getMeetingstart().getTime() < new Date().getTime() && meetingVO.getMeetingstop().getTime() > new Date().getTime()) {
                meeting.setMeetingstate("进行中");
            } else if (meetingVO.getMeetingstop().getTime() < new Date().getTime()) {
                meeting.setMeetingstate("已结束");
            }
        }
        model.addAttribute("list",list);
        return "meetingnotice";
    }

    @RequestMapping("employee/torecordlist")
    public String torecordlist(Model model){
        logger.info("进入会议记录列表页面");
        List<RecordVO> list = recordService.findVOAll();
        model.addAttribute("list",list);
        return "recordlist";
    }

    @RequestMapping("employee/toaddrecord")
    public String toaddrecord(Model model){
        logger.info("去添加会议记录界面");
        List<MeetingVO> list = new ArrayList<>();
        List<MeetingVO> meetings = meetingService.findVOAll();
        logger.info(meetings);
        for (MeetingVO meeting:meetings){
            if (recordService.findByMid(meeting.getMid())==null&&meeting.getMeetingstate().equals("已结束")){
                list.add(meeting);
            }
        }
        logger.info(list);
        model.addAttribute("list",list);
        return "toaddrecord";
    }


    @RequestMapping("employee/addrecord")
    public String addrecord(int mid,Model model){
        MeetingVO meeting = meetingService.findVOByMid(mid);
        model.addAttribute("meeting",meeting);
        return "addrecord";
    }

    @RequestMapping("employee/addrecords")
    public String addrecords(Record record){
        logger.info("添加");
        logger.info(recordService.add(record));
        return "redirect:/employee/torecordlist.action";
    }

    @RequestMapping("employee/tomeetinginfo")
    public String tomeetinginfo(int mid,Model model){
        MeetingVO meetingVO = meetingService.findVOByMid(mid);
        model.addAttribute("meeting",meetingVO);
        return "meetinginfo";
    }

    @RequestMapping("employee/torecordinfo")
    public String torecordinfo(int reid,Model model){
        RecordVO recordVO = recordService.findVOByReid(reid);
        model.addAttribute("recordVO",recordVO);
        return "recordinfo";
    }





}
