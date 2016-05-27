package com.mszostok.service;

import com.mszostok.domain.Tag;
import com.mszostok.exception.TagNotFoundException;
import com.mszostok.model.PostWrapper;
import com.mszostok.repository.TagRepository;
import com.mszostok.util.CustomConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author mszostok
 */
@Service("tagService")
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public Optional<Tag> getTagByTitle(String title) {
        return  tagRepository.findOneByTitle(title);
    }

    @Override
    public List<PostWrapper> getAllPostByTag(String tag) throws TagNotFoundException {

        return tagRepository.findOneByTitle(tag).orElseThrow(() -> new TagNotFoundException(tag)).getPosts()
                .stream()
                .filter(post -> !post.getIsDeleted())
                .map(CustomConverter::postToTeaserPost)
                .collect(Collectors.toList());

    }
}
