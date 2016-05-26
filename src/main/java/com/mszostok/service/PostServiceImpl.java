package com.mszostok.service;

import com.mszostok.Specification.NotDeletedPostForSetMonthAndYearDate;
import com.mszostok.domain.Post;
import com.mszostok.domain.Tag;
import com.mszostok.domain.User;
import com.mszostok.exception.PostException;
import com.mszostok.model.FullPost;
import com.mszostok.model.PostCreateForm;
import com.mszostok.model.TeaserPost;
import com.mszostok.repository.PostRepository;
import com.mszostok.repository.TagRepository;
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

    private static final int MAX_PAGE_SIZE = 2;

    @Autowired
    PostRepository postRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    PostArchiveSidebarService postArchiveService;

    private void setDelete(int id, boolean delete) {
        Post post = postRepository.findOne(id);

        post.setIsDeleted(delete);
    }

    private HashSet<Tag> getTagSetFromTagsInput(String tags) {

        //remove all html tags
        String safeTagsInput = Jsoup.parse(tags).text();

        //remove all whitespace, create list with comma delimiter
        List<String> tagsList = Arrays.asList(safeTagsInput.replaceAll("\\s+", "").split(","));

        //get tag from table or if not exists create new one
        return tagsList.stream().map(title -> tagRepository.findOneByTitle(title).orElse(new Tag(title)))
                .collect(Collectors.toCollection(HashSet<Tag>::new));
    }

    @Override
    public Page<TeaserPost> getPostsForPage(int pageNumber) {
        /**
         * pageNumber -1 due to page start with 0, but first page number for user will be 1,
         * we sorting by post date with descending direction to get proper order at blog page.
         */
        PageRequest pageRequest = new PageRequest(pageNumber - 1, MAX_PAGE_SIZE, Sort.Direction.DESC, "postDate");

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
        //Add actual time for created post.
        post.setPostDate(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
        post.setTitle(form.getTitle());

        /// Anonymous post when user is null
        post.setUser(user.orElse(null));

        post.setTags(getTagSetFromTagsInput(form.getTagsInput()));

        LOGGER.debug("Save post {} to database.", post);
        postRepository.save(post);
        postArchiveService.setUpdate(true);
    }

    @Override
    public Collection<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void deactivateById(int id) {
        setDelete(id, true);
        postArchiveService.setUpdate(true);
    }

    @Override
    public void restoreById(int id) {
        setDelete(id, false);
        postArchiveService.setUpdate(true);
    }

    @Override
    public List<TeaserPost> getPostByMonthAndYear(Integer month, Integer year) {

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(year, month - 1, 1);
        Date date = calendar.getTime();

        NotDeletedPostForSetMonthAndYearDate notDeletedPostForSetMonthAndYearDate = new NotDeletedPostForSetMonthAndYearDate(date);
        List<Post> posts = postRepository.findAll(notDeletedPostForSetMonthAndYearDate);

        return posts
                .stream()
                .map(CustomConverter::postToTeaserPost)
                .collect(Collectors.toList());
    }

}
