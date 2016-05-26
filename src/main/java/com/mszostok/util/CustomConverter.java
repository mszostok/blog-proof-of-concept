package com.mszostok.util;

import com.mszostok.domain.Post;
import com.mszostok.domain.UserRole;
import com.mszostok.model.FullPost;
import com.mszostok.model.TeaserPost;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * Collection of custom converters
 *
 * @author mszostok
 */
public class CustomConverter {

    public static Function<List<UserRole>, String[]> roleListToStringArray
            = userRoles -> userRoles.stream().map(UserRole::getRole).toArray(String[]::new);

    /**
     * Can't use Function due to page map function need
     * Converter class ( <S> Page<S> map(Converter<? super T, ? extends S> converter); )
     * and stream map use Function ( <R> Stream<R> map(Function<? super T, ? extends R> mapper); )
     * but all can apply regular function
     **/
    public static TeaserPost postToTeaserPost(Post post) {
        TeaserPost teaserPost = new TeaserPost(post);
        return teaserPost;
    }

    public static FullPost postToFullPost(Post post) {
        FullPost fullPost = new FullPost(post);
        return fullPost;
    }

    public static String urlDateToPrettyDate(Integer year, Integer month) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM u", Locale.US);
        LocalDateTime dateTime = LocalDateTime.of(year, month, 1, 1, 1);
        return dateTime.format(formatter);
    }
}
