package com.mszostok.service;


import com.mszostok.domain.Post;
import com.mszostok.domain.User;
import com.mszostok.model.PostCreateForm;
import com.mszostok.model.PostWrapper;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;


/**
 * @author mszostok
 */
public interface PostService {

    Page<PostWrapper> getPostsForPage(int pageNumber);

    PostWrapper getById(Integer postId);

    void save(PostCreateForm form, Optional<User> user);

    Collection<Post> getAllPosts();

    void deactivateById(int id);

    void restoreById(int id);

    List<PostWrapper> getPostByMonthAndYear(Integer month, Integer year);

}
