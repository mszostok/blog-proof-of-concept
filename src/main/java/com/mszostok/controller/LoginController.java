package com.mszostok.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Login controller to handle spring security log in failure.
 *
 * @author mszostok
 */
@Controller
public class LoginController {
    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginForm(@RequestParam(value = "error", required = false) Optional<String> error,
                                  HttpServletRequest request, RedirectAttributes redirectAttributes) {

        error.ifPresent($ -> LOGGER.error("An error occurred during log in (spring security add error param)"));

        String referer = "redirect:" + request.getHeader("Referer");
        redirectAttributes.addFlashAttribute("error", error);

        LOGGER.info("Redirect login form to : {}", referer);
        return new ModelAndView(referer);
    }

}
