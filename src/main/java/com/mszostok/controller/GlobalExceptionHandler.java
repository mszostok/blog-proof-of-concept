package com.mszostok.controller;

import com.mszostok.exception.PostException;
import com.mszostok.exception.TagNotFoundException;
import com.mszostok.model.ErrorInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({FileUploadBase.SizeLimitExceededException.class, MultipartException.class})
    @ResponseBody ErrorInfo handleSizeUploadLimitException(HttpServletRequest req, Exception ex) {

        LOGGER.error("Request: {} raised {}", req.getRequestURL(), ex);

        LOGGER.info("Return error info json." );
        return new ErrorInfo(req.getRequestURL().toString(), "File not uploaded (it's too much big)");
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