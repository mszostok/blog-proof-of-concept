package com.mszostok.model;

import com.mszostok.domain.User;

import java.util.Date;

/**
 * Base for post wrapper model.
 *
 * @author mszostok
 */
public abstract class PostWrapper {
    private Integer idPost;

    private Date postDate;

    private String title;

    private String content;

    private String userFullName;

    public PostWrapper() {
    }

    public PostWrapper(String content, Integer idPost, Date postDate, String title, String userFullName) {
        this.content = content;
        this.idPost = idPost;
        this.postDate = postDate;
        this.title = title;
        this.userFullName = userFullName;
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
