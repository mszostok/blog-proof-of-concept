package com.mszostok.service;


import com.mszostok.model.TeaserPost;
import org.springframework.data.domain.Page;


/**
 * @author mszostok
 */
public interface PostService {

    Page<TeaserPost> getPostsForPage(int pageNumber);
}
