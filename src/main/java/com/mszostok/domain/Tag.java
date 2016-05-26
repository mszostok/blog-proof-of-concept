package com.mszostok.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * @author mszostok
 */
@Entity
@Table(name = "tags", schema = "public")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tags_id_tags_seq")
    @SequenceGenerator(name = "tags_id_tags_seq", sequenceName = "tags_id_tags_seq", allocationSize = 1)
    @Column(name = "id_tags", nullable = false)
    private Integer idTag;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    private Set<Post> posts;

    public Integer getIdTag() {
        return idTag;
    }

    public void setIdTag(Integer idTag) {
        this.idTag = idTag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        if (idTag != null ? !idTag.equals(tag.idTag) : tag.idTag != null) return false;
        return title != null ? title.equals(tag.title) : tag.title == null;

    }

    @Override
    public int hashCode() {
        int result = idTag != null ? idTag.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
