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

    private static final String HOME_PAGE = "index";


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView(HOME_PAGE);

        return modelAndView;
    }

}
