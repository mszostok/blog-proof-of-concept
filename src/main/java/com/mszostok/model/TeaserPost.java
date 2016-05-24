package com.mszostok.model;

import com.mszostok.domain.Post;
import com.mszostok.domain.User;
import com.mszostok.util.SlugGenerator;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author mszostok
 */
public class TeaserPost extends PostWrapper {

    private static final Integer TeaserContentSize = 255;

    private String url;

    public TeaserPost(String content, Integer idPost, Timestamp postDate, String title, User user) {
        super(content.substring(0, TeaserContentSize), idPost,  new Date(postDate.getTime()), title, user);
        url = SlugGenerator.toSlug(title);
    }

    public TeaserPost(Post post) {
        super(post.getContent().substring(0, TeaserContentSize).concat("..."),
                post.getIdPost(),
                new Date(post.getPostDate().getTime()),
                post.getTitle(),
                post.getUser());
        url = SlugGenerator.toSlug(post.getTitle());
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
