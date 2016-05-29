package com.mszostok.specification;

import com.mszostok.domain.Post;
import org.springframework.data.jpa.domain.Specification;


import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Defines a specification as a predicate over an Post which return all post for given
 * date, with focus only on year and month
 * @author mszostok
 */
public class NotDeletedPostForSetMonthAndYearDate implements Specification<Post> {

    private final Date date;

    public NotDeletedPostForSetMonthAndYearDate(Date date) {
        this.date = date;
    }
    @Override
    public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (date != null) {
            Calendar dateCalendar = Calendar.getInstance();
            dateCalendar.setTime(date);

            Path<Date> rootPostDate = root.get("postDate");
            return cb.and(
                    cb.equal(cb.function("year", Integer.class, rootPostDate), dateCalendar.get(Calendar.YEAR)),
                    cb.equal(cb.function("month", Integer.class, rootPostDate), dateCalendar.get(Calendar.MONTH) + 1),
                    cb.isFalse(root.get("isDeleted"))
            );

        }
        return null;
    }


}