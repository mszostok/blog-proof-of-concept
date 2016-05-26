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

    private Boolean update;

    @Autowired
    PostRepository postRepository;

    public PostArchiveSidebarServiceImpl() {
        update = true;
        postArchiveSidebarPositions = new LinkedList<>();
    }

    @Transactional(readOnly = true)
    private void updateDatesList() {
        LOGGER.info("Create archive date list only for existing monthsAndYears");

        monthsAndYears = postRepository.findAll(new Sort(Sort.Direction.DESC, "postDate"))
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
        if (update) {
            updateArchiveList();
            update = false;
        }
        return postArchiveSidebarPositions;
    }

    public Boolean getUpdate() {
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }
}
