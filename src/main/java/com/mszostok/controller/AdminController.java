package com.mszostok.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mszostok
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger LOGGER = LogManager.getLogger(AdminController.class);

    private static final String ADMIN_TEMPLATE = "layouts/adminPanelTemplate";
    private static final String ADMIN_PANEL_HOME = "admin/panelHome";


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView homePanel(){

        LOGGER.info("Return home panel view : {} ", ADMIN_PANEL_HOME);

        ModelAndView modelAndView = new ModelAndView(ADMIN_TEMPLATE);
        modelAndView.addObject("pageContentPath", ADMIN_PANEL_HOME);

        return modelAndView;
    }


}
