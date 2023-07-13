package com.hs.web;

import com.hs.po.Account;
import com.hs.po.Bookmarks;
import com.hs.po.Collect;
import com.hs.service.BookmarksService;
import com.hs.service.CollectService;
import com.hs.vo.BookmarksVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author cc
 * 收藏夹控制器
 */
@RequestMapping("employee")
@Controller
public class BookmarksController {

    Logger logger = Logger.getLogger(BookmarksController.class);

    @Autowired
    BookmarksService bookmarksService;

    @Autowired
    CollectService collectService;

    @RequestMapping("/toaddbookmarks")
    public String toAddBookMarks() {
        logger.info("进入tobookmarks.action");
        return "addbookmarks";
    }

    @RequestMapping("/addbookmarks")
    public String addBookMarks(String bmname, Integer aid) {
        logger.info("进入addbookmarks.action");
        Bookmarks bookmarks = new Bookmarks();
        logger.info("准备获取account");
        bookmarks.setAid(aid);
        bookmarks.setBmname(bmname);
        bookmarksService.add(bookmarks);
        return "redirect:/employee/tocollect.action?bmid=-99&aid="+aid;
    }

    @RequestMapping("/toupdatebookmarks")
    public String toupdatebookmarks(Model model,int bmid) {
        logger.info("进入toupdatebookmarks.action");
        Bookmarks bookmarks=bookmarksService.findByBmid(bmid);
        logger.info(bookmarks);
        model.addAttribute("bookmarks",bookmarks);
        return "updatebookmarks";
    }

    @RequestMapping("/updatebookmarks")
    public String updatebookmarks(String bmname,int bmid,int aid) {
        logger.info("进入updatebookmarks.action");
        Bookmarks bookmarks=bookmarksService.findByBmid(bmid);
        logger.info(bookmarks);
        bookmarks.setBmname(bmname);
        bookmarksService.update(bookmarks);
        return "redirect:/employee/tocollect.action?bmid=-99&aid="+aid;
    }

    @RequestMapping("/deletebookmarks")
    public String deletebookmarks(int bmid){
        logger.info("进入deletebookmarks.action");
        List<Collect> list = collectService.findByBmid(bmid);
        int aid = bookmarksService.findByBmid(bmid).getAid();
        logger.info(list.size());
        int[] arr = new int[list.size()];
        if (list!=null){
            for (int i = 0;i<list.size();i++){
                arr[i] =list.get(i).getCid();
            }
            collectService.delete(arr);
        }

        bookmarksService.delete(bmid);

        return "redirect:/employee/tocollect.action?bmid=-99&aid="+aid;
    }
}
