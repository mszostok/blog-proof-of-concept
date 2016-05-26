package com.mszostok.service;

import com.mszostok.domain.Post;
import com.mszostok.domain.User;
import com.mszostok.exception.PostException;
import com.mszostok.model.FullPost;
import com.mszostok.model.PostCreateForm;
import com.mszostok.model.TeaserPost;
import com.mszostok.repository.PostRepository;
import com.mszostok.repository.PostSpecification;
import com.mszostok.util.CustomConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author mszostok
 */
@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = LogManager.getLogger(PostServiceImpl.class);
    /**
     * Max number of post per page
     */
    private static final int PAGE_SIZE = 2;

    @Autowired
    PostRepository postRepository;

    private void setDelete(int id, boolean delete) {
        Post post = postRepository.findOne(id);

        post.setIsDeleted(delete);
    }

    @Autowired
    PostArchiveSidebarService postArchiveSidebarService;

    @Override
    public Page<TeaserPost> getPostsForPage(int pageNumber) {
        /**
         * pageNumber -1 due to page start with 0, but first page number for user will be 1,
         * we sorting by post date with descending direction to get proper order at blog page.
         */
        PageRequest pageRequest = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "postDate");

        postArchiveSidebarService.getArchiveList();
        return postRepository.findByIsDeletedFalse(pageRequest).map(CustomConverter::postToTeaserPost);

    }


    @Override
    public FullPost getById(Integer postId) {
        return CustomConverter.postToFullPost(postRepository.findByIdPost(postId).orElseThrow(() -> new PostException("Could not find post.")));
    }

    @Override
    public void save(PostCreateForm form, Optional<User> user) {
        Post post = new Post();
        /** Use the jsoup HTML Cleaner with a configuration specified by a Whitelist to avoid XSS */
        LOGGER.info("Clean form content to avoid XSS.");
        String safeContent = Jsoup.clean(form.getContent(), Whitelist.basicWithImages());

        post.setContent(safeContent);
        post.setPostDate(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
        post.setTitle(form.getTitle());

        /** Anonymous post */
        post.setUser(user.orElse(null));

        LOGGER.debug("Save post {} to database.", post);
        postRepository.save(post);
    }

    @Override
    public Collection<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void deactivateById(int id) {
        setDelete(id, true);
    }

    @Override
    public void restoreById(int id) {
        setDelete(id, false);
    }

    @Override
    public List<TeaserPost> getPostByMonthAndYear(Integer month, Integer year) {

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(year, month - 1, 1);
        Date date = calendar.getTime();

        PostSpecification postSpecification = new PostSpecification(date);
        List<Post> posts = postRepository.findAll(postSpecification);

        return posts
                .stream()
                .map(CustomConverter::postToTeaserPost)
                .collect(Collectors.toList());
    }

}
