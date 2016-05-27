package com.mszostok.service;

import com.mszostok.domain.Tag;
import com.mszostok.model.PostWrapper;

import java.util.List;
import java.util.Optional;

/**
 * @author mszostok
 */
public interface TagService {
    Optional<Tag> getTagByTitle(String title);

    List<PostWrapper> getAllPostByTag(String tag);
}
