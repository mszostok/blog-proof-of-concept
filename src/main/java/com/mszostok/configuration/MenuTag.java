package com.mszostok.configuration;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author mszostok
 */
public class MenuTag extends TagSupport {

    private static final String START_TAG = "<a href = \"{path}\" class=\"list-group-item {class}\" >";
    private static final String CONTENT = "{icon}{name}";
    private static final String END_TAG = "</a>";

    private String path;
    private String icon;
    private String active;
    private String name;

    public void setPath(String path) {
        this.path = path;
    }

    public void setActive(String active) {
        this.active = active;
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
            String cssClass = active.equals(path) ? "active" : "" ;
            String iconPrint = "";
            if (icon != "") {
                iconPrint = "<i class=\"fa " + icon + "\" aria-hidden=\"true\"></i> ";
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
        } catch (Exception e) {
            System.out.println(e);
        }
        return SKIP_BODY;
    }

}
