package com.mszostok.service;

import com.mszostok.domain.Post;
import com.mszostok.model.FullPost;
import com.mszostok.model.TeaserPost;
import com.mszostok.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @author mszostok
 */
@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {
    /**
     * Max number of post per page
     */
    private static final int PAGE_SIZE = 2;

    @Autowired
    PostRepository postRepository;

    private TeaserPost convertToTeaserPost(Post post){
        TeaserPost teaserPost = new TeaserPost(post);

        return teaserPost;
    }

    private FullPost convertToFullPost(Post post){
        if(post != null) {
            FullPost fullPost = new FullPost(post);
            return fullPost;
        }
        return null;
    }

    @Override
    public Page<TeaserPost> getPostsForPage(int pageNumber) {
        /**
         * pageNumber -1 due to page start with 0, but first page number for user will be 1,
         * we sorting by post date with descending direction to get proper order at blog page.
         */
        PageRequest pageRequest = new PageRequest(pageNumber-1, PAGE_SIZE, Sort.Direction.DESC, "postDate");

        return postRepository.findByIsDeletedFalse( pageRequest ).map(this::convertToTeaserPost);
    }

    @Override
    public FullPost getById(Optional<Integer> postId) {
        return convertToFullPost(postRepository.findByIdPost(postId.get()));
    }
}
