package com.hs.web;

import com.hs.po.Bookmarks;
import com.hs.po.Collect;
import com.hs.po.Study;
import com.hs.service.BookmarksService;
import com.hs.service.CollectService;
import com.hs.service.StudyService;
import com.hs.vo.BookmarksVO;
import com.hs.vo.CollectVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author cc
 * 收藏内容控制器
 */
@Controller
public class CollectController {

    Logger logger=Logger.getLogger(CollectController.class);

    @Autowired
    CollectService collectService;
    @Autowired
    BookmarksService bookmarksService;
    @Autowired
    StudyService studyService;

    @RequestMapping("employee/tocollect")
    public String toCollect(Model model,int aid,int bmid){
        logger.info(bmid);
        logger.info("进入tocollect.action");
        List<BookmarksVO> listbook=bookmarksService.findVOByAid(aid);
        logger.info(listbook);
        List<List> list=new ArrayList<>();
        if (bmid==-99){
            for (BookmarksVO bookmarksVO:listbook){
                list.add(collectService.findVOByBmid(bookmarksVO.getBmid()));
            }
        }else{
            list.add(collectService.findVOByBmid(bmid));
        }
        logger.info(list);
        logger.info(listbook);
        model.addAttribute("list",list);
        model.addAttribute("listbook",listbook);

        return "collect";
    }

    @RequestMapping("employee/toupdatecollect")
    public String toupdatecollect(Model model,Integer cid,Integer aid){
        logger.info("进入toupdatecollect.action");
        CollectVO collectVO=collectService.findVOByCid(cid);
        logger.info(collectVO);
        model.addAttribute("collectVO",collectVO);
       List <BookmarksVO> list=bookmarksService.findVOByAid(aid);
       logger.info(list);
       model.addAttribute("list",list);
        return "updatecollect";
    }

    @RequestMapping("employee/updatecollect")
    public String updatecollect(Integer cid, Integer bmid){
        logger.info("进入updatecollect.action");
        Collect collect=collectService.findByCid(cid);
        logger.info(collect);
        collect.setBmid(bmid);
        collectService.update(collect);
        Bookmarks bookmarks = bookmarksService.findByBmid(bmid);
        int aid = bookmarks.getAid();
        logger.info(aid);
        return "redirect:/employee/tocollect.action?bmid=-99&aid="+aid;
    }

    @RequestMapping("employee/deletecollect")
    public String deletecollect(Integer aid,int[] idss){
        logger.info("进入deletecollect.action");
        logger.info(Arrays.toString(idss));
        collectService.delete(idss);
        logger.info(aid);
        return "redirect:/employee/tocollect.action?bmid=-99&aid="+aid;
    }

    @RequestMapping("employee/findbybmid")
    public String findbybmid(Integer aid,int bmid,Model model){
        logger.info("进入findbybmid.action");
        List<CollectVO> list=collectService.findVOByBmid(bmid);
        logger.info(list);
        model.addAttribute("list",list);
        return "redirect:/employee/tocollect.action?bmid=-99&aid="+aid;
    }

    @RequestMapping("personnel/tocollectchart")
    public String tochartinfo() {
        logger.info("进入tocollectchart.action");
        return "collectchart";
    }

    @RequestMapping("personnel/collectchart")
    @ResponseBody
    public Map<String, List> chartsecond(Model model) {
        logger.info("进入collectchart.action");
        Map<String, List> map = collectService.findBar();
        logger.info(map);
        model.addAttribute("map",map);
        return map;
    }

    @RequestMapping("employee/toaddcollect")
    public String toaddcollect(int stuid,int aid,Model model){
        logger.info("进入toaddcollect.action");
        Study study=studyService.findByStuid(stuid);
        logger.info(study);
        model.addAttribute("study",study);
        List<BookmarksVO> list=bookmarksService.findVOByAid(aid);
        model.addAttribute("list",list);
        return "addcollect";
    }

    @RequestMapping("employee/checkstuid")
    @ResponseBody
    public boolean checkstuid(int stuid, int aid){
        logger.info(stuid);
        boolean flag=false;
        List<Bookmarks> list=bookmarksService.findByAid(aid);
        List<Collect> collectlist=new ArrayList<>();
        ArrayList<Object> stuidlist=new ArrayList<>();
        for(Bookmarks bookmarks:list){
            collectlist=(collectService.findByBmid(bookmarks.getBmid()));
            for(Collect collect:collectlist){
                stuidlist.add(collect.getStuid());
                flag=(stuidlist.contains(stuid))?true:false;
            }
        }
        return flag;
    }

    @RequestMapping("employee/addcollect")
    public String addcollect(int aid,int bmid,int stuid){
        logger.info("进入addcollect.action");
        Collect collect=new Collect();
        collect.setBmid(bmid);
        collect.setStuid(stuid);
        collectService.add(collect);
        return "redirect:/employee/tocollect.action?bmid=-99&aid="+aid;
    }
}
