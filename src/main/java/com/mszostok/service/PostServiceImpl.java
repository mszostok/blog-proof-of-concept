package com.mszostok.service;

import com.mszostok.domain.Post;
import com.mszostok.model.TeaserPost;
import com.mszostok.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author mszostok
 */
@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {
    private static final int PAGE_SIZE = 2;

    @Autowired
    PostRepository postRepository;

    @Override
    public Page<Post> getPostsForPage(int pageNumber) {
        PageRequest request = new PageRequest(pageNumber-1, PAGE_SIZE, Sort.Direction.DESC, "postDate");

        return postRepository.findByIsDeletedFalse( request );
    }


}
