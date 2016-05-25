package com.mszostok.model;

import com.mszostok.domain.Post;
import com.mszostok.domain.User;

import java.util.Date;

/**
 * Post model which provide whole information need to print in details post view.
 *
 * @author mszostok
 */
public class FullPost extends  PostWrapper {

    public FullPost(Post post) {
        content = post.getContent();
        idPost = post.getIdPost();
        postDate = new Date(post.getPostDate().getTime());
        title = post.getTitle();

        User user = post.getUser();
        if(user == null) {
            userFullName = "Anonymous";
        } else {
            userFullName = user.getFirstName().concat(" ").concat(user.getLastName());
        }
    }
}
