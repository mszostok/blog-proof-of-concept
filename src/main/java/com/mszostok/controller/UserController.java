package com.mszostok.controller;

import com.mszostok.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * User controller to handle user management request mapping.
 *
 * @author mszostok
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;


    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/deactivate/{id}", method = RequestMethod.POST)
    public String deactivateClient(@PathVariable int id, HttpServletRequest request) {
        LOGGER.info("Execute deactivateClient method - only for ADMIN user");

        userService.deactivateById(id);

        String referer = request.getHeader("Referer");
        LOGGER.info("Redirect view to: {} ", referer);
        return "redirect:" + referer;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/activate/{id}", method = RequestMethod.POST)
    public String activateClient(@PathVariable int id, HttpServletRequest request) {
        LOGGER.info("Execute activateClient method - only for ADMIN user");

        userService.activateById(id);

        String referer = request.getHeader("Referer");
        LOGGER.info("Redirect view to: {} ", referer);
        return "redirect:" + referer;
    }

}
