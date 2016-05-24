package com.mszostok.service;


import com.mszostok.model.FullPost;
import com.mszostok.model.PostCreateForm;
import com.mszostok.model.TeaserPost;
import org.springframework.data.domain.Page;

import java.util.Optional;


/**
 * @author mszostok
 */
public interface PostService {

    Page<TeaserPost> getPostsForPage(int pageNumber);

   FullPost getById(Integer postId);

    void save(PostCreateForm form);
}
