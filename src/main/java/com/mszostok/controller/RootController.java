package com.mszostok.controller;

import com.mszostok.domain.Post;
import com.mszostok.model.TeaserPost;
import com.mszostok.service.PostService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


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
    private static final String HOMEPAGE_CONTENT = "site/homepage";


    @Autowired
    PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){

        LOGGER.info("Return index view: ".concat(HOMEPAGE_CONTENT));

        ModelAndView modelAndView = new ModelAndView(HOME_PAGE_TEMPLATE);
        modelAndView.addObject("pageContentPath", HOMEPAGE_CONTENT);

        /** Posts **/
        Page<Post> posts = postService.getPostsForPage(1);
        modelAndView.addObject("posts", posts.getContent());


        return modelAndView;
    }

}
