package com.mszostok.service;

import com.mszostok.domain.Post;
import com.mszostok.model.PostArchiveSidebarPosition;
import com.mszostok.repository.PostRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mszostok
 */
@Service("postArchiveSidebarService")
public class PostArchiveSidebarService {
    private static final Logger LOGGER = LogManager.getLogger(PostArchiveSidebarService.class);

    private static final Calendar cal = Calendar.getInstance();

    private LinkedList<PostArchiveSidebarPosition> postArchiveSidebarPositions;

    private Date theOldestPostDate;
    private Date theNewestPostDate;

    private Boolean update;

    @Autowired
    PostRepository postRepository;

    public PostArchiveSidebarService() {
        update = true;
        postArchiveSidebarPositions = new LinkedList<>();
    }

    @Transactional( readOnly = true )
    private void updateDatesRange() {
        //FIXME change range to date list where posts are available - remove date which don't contain notes
        LinkedList<Post> posts = postRepository.findAll(new Sort(Sort.Direction.DESC, "postDate"))
                .stream()
                .collect(Collectors.toCollection(LinkedList::new));

        theOldestPostDate = posts.getLast().getPostDate();
        theNewestPostDate = posts.getFirst().getPostDate();

        LOGGER.info("Archive sidebar date list range: < {} , {} >", theOldestPostDate, theNewestPostDate);
    }

    private void updatePostPositionList() {

        LOGGER.info("Clear archive sidebar list");
        postArchiveSidebarPositions.clear();

        cal.setTime(theOldestPostDate);
        YearMonth startDate = YearMonth.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
        cal.setTime(theNewestPostDate);
        YearMonth endDate = YearMonth.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1); // add 1 to include also this month

        LOGGER.info("Creating new archive sidebar list from:  {} to {} ", endDate, startDate);
        while (endDate.isAfter(startDate)) {
            postArchiveSidebarPositions.add(new PostArchiveSidebarPosition(endDate));
            endDate = endDate.minusMonths(1);
        }
    }

    private void updateArchiveList() {
        LOGGER.info("Update archive sidebar list");

        updateDatesRange();
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
