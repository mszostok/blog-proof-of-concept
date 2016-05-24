package com.mszostok.model;

import com.mszostok.domain.Post;

import java.util.Date;

/**
 * Post model which provide whole information need to print in details post view.
 *
 * @author mszostok
 */
public class FullPost extends  PostWrapper {

    public FullPost(Post post) {
        super(post.getContent(),
                post.getIdPost(),
                new Date(post.getPostDate().getTime()),
                post.getTitle(),
                post.getUser());
    }
}
