package com.jnshu.controller;

import com.jnshu.model.User;
import com.jnshu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 56929 on 2017/5/11.
 */
@Controller

public class controller {
    private Logger log = org.apache.log4j.Logger.getLogger(controller.class);
    @Autowired
    private UserService userService;
    @RequestMapping("/list")
    public String showUser(Model model){
        log.info("查询用户");
        List<User> userList = userService.selectAllUser();
        model.addAttribute("userList",userList);
        return "list";
    }

}
