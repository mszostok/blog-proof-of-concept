package com.mszostok.service;


import com.mszostok.domain.Post;
import org.springframework.data.domain.Page;


/**
 * @author mszostok
 */
public interface PostService {

    Page<Post> getPostsForPage(int pageNumber);
}
