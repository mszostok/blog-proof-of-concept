package com.mszostok.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author mszostok
 */
@Entity
@Table(name = "posts", schema = "public")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="posts_id_post_seq")
    @SequenceGenerator(name="posts_id_post_seq", sequenceName="posts_id_post_seq", allocationSize=1)
    @Column(name = "id_post", nullable = false)
    private Integer idPost;

    @Column(name = "post_date", nullable = false)
    private Timestamp postDate;

    @Column(name = "post_title", nullable = false)
    private String title;

    @Column(name = "post_content", nullable = false)
    private String content;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "users_id_user")
    private User user;

    public Post() {
    }

    public Post(String content, boolean isDeleted, Timestamp postDate, String title, User user) {
        this.content = content;
        this.isDeleted = isDeleted;
        this.postDate = postDate;
        this.title = title;
        this.user = user;
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

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (isDeleted != post.isDeleted) return false;
        if (idPost != null ? !idPost.equals(post.idPost) : post.idPost != null) return false;
        if (postDate != null ? !postDate.equals(post.postDate) : post.postDate != null) return false;
        if (title != null ? !title.equals(post.title) : post.title != null) return false;
        if (content != null ? !content.equals(post.content) : post.content != null) return false;
        if (user != null ? !user.equals(post.user) : post.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPost != null ? idPost.hashCode() : 0;
        result = 31 * result + (postDate != null ? postDate.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (isDeleted ? 1 : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                ", idPost=" + idPost +
                ", postDate=" + postDate +
                ", title='" + title + '\'' +
                ", isDeleted=" + isDeleted +
                ", user=" + user +
                '}';
    }
}
