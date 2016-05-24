package com.mszostok.model;

import com.mszostok.domain.User;

import java.util.Date;

/**
 * Base for post wrapper model.
 *
 * @author mszostok
 */
public abstract class PostWrapper {
    protected Integer idPost;

    protected Date postDate;

    protected String title;

    protected String content;

    protected String userFullName;

    public PostWrapper() {
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
