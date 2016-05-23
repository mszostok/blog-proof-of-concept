package com.mszostok.repository;

import com.mszostok.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author mszostok
 */
public interface PostRepository extends JpaRepository<Post, Integer> {

    Page<Post> findByIsDeletedFalse(Pageable pageable);
}
