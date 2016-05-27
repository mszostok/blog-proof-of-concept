package com.mszostok.model;


import com.mszostok.domain.Post;
import com.mszostok.domain.User;
import com.mszostok.util.SlugGenerator;
import org.jsoup.Jsoup;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Base for post wrapper model.
 *
 * @author mszostok
 */
public class PostWrapper {
    private Integer idPost;

    private Date postDate;

    private String title;
    private String content;
    private String userFullName;
    private String url;

    private List<String> tags;


    /**
     * Strong limited builder, only choose between teaser and full post option, if teaser you can set
     * max content size.
     *
     * Default build full post.
     */
    public static class Builder {
        private static final Integer MAX_TEASER_CONTENT_SIZE = 255;

        Integer idPost;
        User user;
        Date postDate;
        Boolean isTeaserPost = false;
        String title, content, userFullName, url;
        List<String> tags = new LinkedList<>();
        Optional<Integer> customTeaserContentSize = null;

        private void setupField(){
            if (isTeaserPost) {
                String html = content.substring(0, Math.min(content.length(), MAX_TEASER_CONTENT_SIZE)).concat("...");
                content = Jsoup.parse(html).text();
            }

            url = (SlugGenerator.toSlug(title));
            userFullName = user == null ? "Anonymous" : user.getFirstName().concat(" ").concat(user.getLastName());

        }
        public Builder(Post post) {
            content = post.getContent();
            idPost = post.getIdPost();
            postDate = new Date(post.getPostDate().getTime());
            title = post.getTitle();
            user = post.getUser();
            tags = post.getTags().stream().map(tag -> tag.getTitle()).collect(Collectors.toList());
        }

        public Builder setTeaserPost(Boolean teaserPost) {
            isTeaserPost = teaserPost;
            return this;
        }

        public Builder customTeaserContentSize(Integer customTeaserContentSize) {
            this.customTeaserContentSize = Optional.of(customTeaserContentSize);
            return this;
        }

        public PostWrapper build() {
            setupField();
            return new PostWrapper(this);
        }
    }

    public PostWrapper() {
    }

    public PostWrapper(Builder builder) {
        tags = new LinkedList<>();

        this.content = builder.content;
        this.idPost = builder.idPost;
        this.postDate = builder.postDate;
        this.tags =  builder.tags;
        this.title =  builder.title;
        this.url =  builder.url;
        this.userFullName =  builder.userFullName;

    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getUrl() {
        return url;
    }

    public PostWrapper setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
