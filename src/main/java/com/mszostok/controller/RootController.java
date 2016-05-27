package com.mszostok.controller;

import com.mszostok.model.PostWrapper;
import com.mszostok.service.PostArchiveSidebarService;
import com.mszostok.service.PostService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


/**
 * Root Controller to handle request mapping for the main blog page (home)
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

    @Autowired
    PostArchiveSidebarService postArchiveService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){

        LOGGER.info("Forward view to: {} ", INDEX_FORWARD);

        ModelAndView modelAndView = new ModelAndView(INDEX_FORWARD);
        return modelAndView;
    }

    @RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
    public ModelAndView getPostPage(@PathVariable Optional<Integer> pageNumber) {

        LOGGER.info("Return view: {} ", HOME_PAGE_CONTENT);
        ModelAndView modelAndView = new ModelAndView(HOME_PAGE_TEMPLATE);
        modelAndView.addObject("pageContentPath", HOME_PAGE_CONTENT);

        LOGGER.info("Get posts for page: {} ", pageNumber.orElse(1));
        Page<PostWrapper> page = postService.getPostsForPage(pageNumber.orElse(1));
        modelAndView.addObject("page", page);

        modelAndView.addObject("archivesList", postArchiveService.getArchiveList());

        return  modelAndView;
    }

}
