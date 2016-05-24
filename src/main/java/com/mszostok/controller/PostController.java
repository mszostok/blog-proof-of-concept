package com.mszostok.controller;

import com.mszostok.model.FullPost;
import com.mszostok.service.PostService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * @author mszostok
 */
@Controller
@RequestMapping("/post")
public class PostController {
    private static final Logger LOGGER = LogManager.getLogger(RootController.class);

    private static final String HOME_PAGE_TEMPLATE = "layouts/siteTemplate";
    private static final String HOME_PAGE_CONTENT = "site/postDetails";

    @Autowired
    PostService postService;

    @RequestMapping(value = "/{postId}/{postTitle}",method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Optional<Integer> postId,
                              @PathVariable Optional<String> postTitle){

        LOGGER.info("Return view: ".concat(HOME_PAGE_CONTENT));

        ModelAndView modelAndView = new ModelAndView(HOME_PAGE_TEMPLATE);
        modelAndView.addObject("pageContentPath", HOME_PAGE_CONTENT);

        FullPost post = postService.getById(postId);
        modelAndView.addObject("post", post);

        return modelAndView;
    }
}
