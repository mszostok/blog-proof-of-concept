package com.mszostok.model;

import com.mszostok.domain.Post;
import com.mszostok.domain.User;
import com.mszostok.util.SlugGenerator;
import org.jsoup.Jsoup;

import java.util.Date;

/**
 * Teaser post which provide enough information about post to display at main blog page.
 *
 * @author mszostok
 */
public class TeaserPost extends PostWrapper {

    private static final Integer MAX_TEASER_CONTENT_SIZE = 255;

    private String url;

    public TeaserPost(Post post) {
        String html = post.getContent().substring(0, Math.min(post.getContent().length(), MAX_TEASER_CONTENT_SIZE)).concat("...");
        content = Jsoup.parse(html).text();
        idPost = post.getIdPost();
        postDate = new Date(post.getPostDate().getTime());
        title = post.getTitle();

        User user = post.getUser();
        if(user == null) {
            userFullName = "Anonymous";
        } else {
            userFullName = user.getFirstName().concat(" ").concat(user.getLastName());
        }

        url = SlugGenerator.toSlug(post.getTitle());
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
