package com.mszostok.configuration;

import com.mszostok.controller.UploadController;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
 *
 * @author mszostok
 */
@Configuration
public class StaticResourceConfig extends WebMvcConfigurerAdapter {

    public static final String STATIC_URL = "/static/**";
    public static final String UPLOAD_URL = "/uploads/**";


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(STATIC_URL).addResourceLocations("/static/");
        registry.addResourceHandler(UPLOAD_URL).addResourceLocations("file:" + UploadController.UPLOAD_LOCATION);
    }
}
