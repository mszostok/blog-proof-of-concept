package com.mszostok.controller;

import com.mszostok.exception.PostException;
import com.mszostok.exception.TagNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Handling any of the exceptions thrown from any controller.
 *
 * @author mszostok
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandler.class);

    private static final String HOME_PAGE_TEMPLATE = "layouts/siteTemplate";
    private static final String DEFAULT_ERROR_VIEW = "error/defaultErrorPage";

    @ExceptionHandler( {PostException.class, TagNotFoundException.class})
    public ModelAndView exception(HttpServletRequest req, RuntimeException ex) {
        LOGGER.error("Request: {} raised {}", req.getRequestURL(), ex);

        ModelAndView modelAndView = new ModelAndView(HOME_PAGE_TEMPLATE);
        modelAndView.addObject("pageContentPath", DEFAULT_ERROR_VIEW);
        modelAndView.addObject("errorMessage", ex.getMessage());

        LOGGER.info("Return error view for post exception" );
        return modelAndView;
    }


    @ExceptionHandler(Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception ex) {
        LOGGER.error("Request: {} raised {}", req.getRequestURL(), ex);

        ModelAndView modelAndView = new ModelAndView(HOME_PAGE_TEMPLATE);

        modelAndView.addObject("errorMessage", "Some error occurred at " +req.getRequestURL());
        modelAndView.addObject("pageContentPath", DEFAULT_ERROR_VIEW);

        LOGGER.info("Return default error page exception" );
        return modelAndView;
    }

}