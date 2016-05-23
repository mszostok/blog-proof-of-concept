package com.mszostok.controller;

import com.mszostok.model.TeaserPost;
import com.mszostok.service.PostService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


/**
 * Root Controller
 *
 * @author mszostok
 */
@Controller
@RequestMapping("/")
public class RootController {

    private static final Logger LOGGER = LogManager.getLogger(RootController.class);

    private static final String HOME_PAGE_TEMPLATE = "layouts/siteTemplate";
    private static final String HOME_PAGE_CONTENT = "site/homepage";
    private static final String INDEX_FORWARD = "forward:/pages/1";


    @Autowired
    PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){

        LOGGER.info("Forward view to: ".concat(INDEX_FORWARD));

        ModelAndView modelAndView = new ModelAndView(INDEX_FORWARD);
        return modelAndView;
    }

    @RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
    public ModelAndView getPostPage(@PathVariable Optional<Integer> pageNumber) {

        LOGGER.info("Get posts for page: " + pageNumber.orElse(1));
        Page<TeaserPost> page = postService.getPostsForPage(pageNumber.orElse(1));

        LOGGER.info("Return view: ".concat(HOME_PAGE_CONTENT));
        ModelAndView modelAndView = new ModelAndView(HOME_PAGE_TEMPLATE);
        modelAndView.addObject("pageContentPath", HOME_PAGE_CONTENT);

        modelAndView.addObject("page", page);
        return  modelAndView;
    }

}
