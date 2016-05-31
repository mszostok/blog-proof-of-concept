package com.mszostok.service;

import com.mszostok.model.PostArchiveSidebarPosition;
import com.mszostok.repository.PostRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Post archive sidebar service which can return archive month list where post are available.
 * Lazy update - only when get list.
 *
 * @author mszostok
 */
@Service("postArchiveSidebarService")
public class PostArchiveSidebarServiceImpl  implements PostArchiveSidebarService{
    private static final Logger LOGGER = LogManager.getLogger(PostArchiveSidebarServiceImpl.class);

    private final String pattern = "yyyy/MM";

    private final SimpleDateFormat DATE_TO_STRING = new SimpleDateFormat(pattern, Locale.ENGLISH);
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM", Locale.ENGLISH);

    private LinkedList<PostArchiveSidebarPosition> postArchiveSidebarPositions;

    private Set<String> monthsAndYears;

    @Autowired
    PostRepository postRepository;

    public PostArchiveSidebarServiceImpl() {
        postArchiveSidebarPositions = new LinkedList<>();
    }

    @Transactional(readOnly = true)
    private void updateDatesList() {
        LOGGER.info("Create archive date list only for existing monthsAndYears");

        //TODO count repeated date  (can be achieved with group by method)
        monthsAndYears = postRepository.findByIsDeletedFalse(new Sort(Sort.Direction.DESC, "postDate"))
                .stream()
                .map(post -> DATE_TO_STRING.format(post.getPostDate()))
                .collect(Collectors.toCollection(TreeSet::new)); //automatically sorted in natural order

    }

    private void updatePostPositionList() {

        LOGGER.info("Clear archive sidebar list");
        postArchiveSidebarPositions.clear();

        LOGGER.info("Create archive sidebar position list for dates {}", monthsAndYears.toArray());
        monthsAndYears.stream()
        .sorted(Comparator.reverseOrder()) //reverse order due to its natural ordered but we want newest dates first.
                .forEach(date -> postArchiveSidebarPositions.add(new PostArchiveSidebarPosition(YearMonth.parse(date, FORMATTER))));

    }

    private void updateArchiveList() {
        LOGGER.info("Update archive sidebar list");

        updateDatesList();
        updatePostPositionList();

    }

    public List<PostArchiveSidebarPosition> getArchiveList() {
            updateArchiveList();
        return postArchiveSidebarPositions;
    }

}
