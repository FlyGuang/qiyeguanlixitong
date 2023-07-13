package com.hs.web;


import com.hs.po.Area;
import com.hs.po.City;
import com.hs.po.Province;
import com.hs.service.AreaService;
import com.hs.service.CityService;
import com.hs.service.ProvinceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author km
 * 省市区联查控制器
 */
@Controller
public class PCAController {
    Logger logger=Logger.getLogger(PCAController.class);
    @Autowired
    ProvinceService provinceService;
    @Autowired
    CityService cityService;
    @Autowired
    AreaService areaService;
    @RequestMapping("/topca")
    public String tipca(){
        logger.info("进入topac控制器....");
        return "toedituser";
    }
    @RequestMapping("/provincelist")
    @ResponseBody
    public List<Province> provincelist(){
        logger.info("进入provincelist控制器。。。。");
        return provinceService.findAll();
    }
    @RequestMapping("/citylist")
    @ResponseBody
    public List<City> citylist(String provinceId){
        logger.info("进入citylist控制器。。。。");
        return cityService.findCityByPid(provinceId);
    }
    @RequestMapping("/arealist")
    @ResponseBody
    public List<Area> arealist(String cityId){
        logger.info("进入arealist控制器。。。。");
        return areaService.findAreaByCid(cityId);
    }
}
