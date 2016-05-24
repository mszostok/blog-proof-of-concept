package com.mszostok.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author mszostok
 */
public class PostCreateForm {

    @NotEmpty(message = "Please fill post title")
    private String title;

    @NotEmpty(message = "Please fill content field")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
