package com.hs.web;

import com.hs.po.Role;
import com.hs.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author km
 * 角色控制器
 */
@RequestMapping("personnel")
@Controller
public class RoleController {
    Logger logger = Logger.getLogger(RoleController.class);
    @Autowired
    RoleService roleService;

    @RequestMapping("rolelist")
    public String rolelist(Model model) {
        logger.info("进入rolelist控制器  。。。");
        List<Role> list = roleService.findAll();
        model.addAttribute("list",list);
        return "roletlist";
    }

    @RequestMapping("toverify.action")
    @ResponseBody
    public boolean toverify(String rname) {
        logger.info("toroleverify。。。");
        logger.info(rname);
        return (roleService.findByRname(rname) != null) ? true : false;
    }

    @RequestMapping("toaddrole")
    public String toaddrole() {
        logger.info("进入toaddrole控制器。。。。");
        return "addrole";
    }

    @RequestMapping("addrole")
    public String addrole(Role role, Model model) {
        logger.info("进入addrole控制器。。。。");
        logger.info(role.getRname());
        if (roleService.findByRname(role.getRname()) != null) {
            model.addAttribute("mess", "此岗位已存在！");
            return "addrole";
        }
        if (role.getRname() == "" || role.getRname() == null) {
            model.addAttribute("mess", "岗位名称不能为空！");
            return "addrole";
        }
        roleService.addRole(role);
        return "redirect:/personnel/rolelist.action";
    }

    @RequestMapping("toeditrole")
    public String toeditrole(int rid, Model model) {
        logger.info("进入toeditrole控制器。。。。");
        model.addAttribute("role", roleService.findById(rid));
        return "editrole";
    }

    @RequestMapping("editrole")
    public String editrole(Role role, Model model) {
        logger.info("进入editrole控制器。。。。");
        if (roleService.findByRname(role.getRname()) != null&&!role.getRname().equals(roleService.findById(role.getRid()).getRname())) {
            model.addAttribute("role", role);
            model.addAttribute("mess", "此岗位已存在！");
            return "editrole";
        }
        if (role.getRname() == "" || role.getRname() == null) {
            model.addAttribute("role", role);
            model.addAttribute("mess", "岗位名称不能为空！");
            return "editrole";
        }
        roleService.updateRole(role);
        return "redirect:/personnel/rolelist.action";
    }
}