package com.mszostok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Root Controller
 *
 * @author mszostok
 */
@Controller
@RequestMapping("/")
public class RootController {

    private static final String HOME_PAGE_TEMPLATE = "layouts/siteTemplate";
    private static final String HOMEPAGE_CONTENT = "site/homepage";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView(HOME_PAGE_TEMPLATE);
        modelAndView.addObject("pageContentPath", HOMEPAGE_CONTENT);

        return modelAndView;
    }

}
