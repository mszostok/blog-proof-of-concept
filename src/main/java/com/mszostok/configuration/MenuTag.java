package com.mszostok.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Custom tag which can be used to print menu list group item.
 * Support custom icon, href link, and activeUrlPattern url pattern.
 *
 * @author mszostok
 */
public class MenuTag extends TagSupport {
    private static final Logger LOGGER = LogManager.getLogger(MenuTag.class);

    private static final String START_TAG = "<a href = \"{path}\" class=\"list-group-item {class}\" >";
    private static final String CONTENT = "{icon}{name}";
    private static final String END_TAG = "</a>";

    private String path;
    private String icon;
    private String activeUrlPattern;
    private String name;

    public void setPath(String path) {
        this.path = path;
    }

    public void setActiveUrlPattern(String activeUrlPattern) {
        this.activeUrlPattern = activeUrlPattern;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    @Override
    public int doStartTag() throws JspException {

        JspWriter out = pageContext.getOut();

        try {
            String cssClass = activeUrlPattern.equals(path) ? "activeUrlPattern" : "" ;

            String iconPrint = "";
            if (!icon.isEmpty()) {
                iconPrint = "<i class=\"fa {fa-icon} \" aria-hidden=\"true\"></i> ".replace("{fa-icon}", icon);
            }

            //column name
            out.write(START_TAG
                    .replace("{path}", path)
                    .replace("{class}", cssClass)
            );
            out.write(CONTENT
                    .replace("{icon}", iconPrint)
                    .replace("{name}", name)
            );
            out.write(END_TAG);
        } catch (Exception ex) {
            LOGGER.error("Error occurred while creating custom tag : {}" ,ex);
        }

        return SKIP_BODY;
    }

}
