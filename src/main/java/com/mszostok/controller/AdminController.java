package com.mszostok.controller;

import com.mszostok.domain.User;
import com.mszostok.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

/**
 * @author mszostok
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger LOGGER = LogManager.getLogger(AdminController.class);

    private static final String ADMIN_TEMPLATE = "layouts/adminPanelTemplate";
    private static final String ADMIN_PANEL_HOME = "admin/panelHome";

    private static final String MANAGE_USERS = "admin/manageUsers";

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView homePanel(){

        LOGGER.info("Return home panel view : {} ", ADMIN_PANEL_HOME);

        ModelAndView modelAndView = new ModelAndView(ADMIN_TEMPLATE);
        modelAndView.addObject("pageContentPath", ADMIN_PANEL_HOME);

        return modelAndView;
    }

    @RequestMapping(value = "/manage-users", method = RequestMethod.GET)
    public ModelAndView manageEmployeePage(){

        ModelAndView modelAndView = new ModelAndView(ADMIN_TEMPLATE);
        modelAndView.addObject("pageContentPath", MANAGE_USERS);

        Collection<User> users = userService.getAllUsers();
        modelAndView.addObject("users", users);

        return modelAndView;
    }

}
