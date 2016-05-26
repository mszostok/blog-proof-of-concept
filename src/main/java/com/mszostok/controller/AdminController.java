package com.mszostok.controller;

import com.mszostok.domain.Post;
import com.mszostok.domain.User;
import com.mszostok.service.PostService;
import com.mszostok.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;


/**
 * Administrator controller for blog management.
 *
 * @author mszostok
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger LOGGER = LogManager.getLogger(AdminController.class);

    private static final String ADMIN_TEMPLATE = "layouts/adminPanelTemplate";
    private static final String ADMIN_PANEL_HOME = "admin/panelHome";

    private static final String MANAGE_USERS = "admin/manageUsers";

    private static final String MANAGE_POSTS= "admin/managePosts";

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView homePanel(){

        LOGGER.info("Return home panel view : {} ", ADMIN_PANEL_HOME);

        ModelAndView modelAndView = new ModelAndView(ADMIN_TEMPLATE);
        modelAndView.addObject("pageContentPath", ADMIN_PANEL_HOME);

        return modelAndView;
    }

    @RequestMapping(value = "/manage-users", method = RequestMethod.GET)
    public ModelAndView manageUserPage(){

        ModelAndView modelAndView = new ModelAndView(ADMIN_TEMPLATE);
        modelAndView.addObject("pageContentPath", MANAGE_USERS);

        Collection<User> users  = userService.getAllUsers();
        LOGGER.debug("Add users list to model : List size {} ", users.size() );
        modelAndView.addObject("users", users);

        LOGGER.info("Return manage user panel view : {} ", MANAGE_USERS);
        return modelAndView;
    }


    @RequestMapping(value = "/manage-posts", method = RequestMethod.GET)
    public ModelAndView managePostPage(){

        ModelAndView modelAndView = new ModelAndView(ADMIN_TEMPLATE);
        modelAndView.addObject("pageContentPath", MANAGE_POSTS);

        Collection<Post> posts  = postService.getAllPosts();
        LOGGER.debug("Add posts list to model : List size {} ", posts.size() );
        modelAndView.addObject("posts", posts);

        LOGGER.info("Return manage posts panel view : {} ", MANAGE_POSTS);
        return modelAndView;
    }
}
