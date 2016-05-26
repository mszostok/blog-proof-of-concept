package com.mszostok.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Post create form model with field validation and suitable message for it.
 *
 * @author mszostok
 */
public class PostCreateForm {

    @NotEmpty(message = "Please fill post title")
    private String title;

    @NotEmpty(message = "Please fill content field")
    private String content;

    private String tagsInput;

    public String getTagsInput() {
        return tagsInput;
    }

    public void setTagsInput(String tagsInput) {
        this.tagsInput = tagsInput;
    }

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
