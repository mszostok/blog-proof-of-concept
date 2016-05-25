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

        userService.deactivateById(id);

        return "redirect:" + request.getHeader("Referer");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/activate/{id}", method = RequestMethod.POST)
    public String activateClient(@PathVariable int id, HttpServletRequest request) {

        userService.activateById(id);

        return "redirect:" + request.getHeader("Referer");
    }

}
