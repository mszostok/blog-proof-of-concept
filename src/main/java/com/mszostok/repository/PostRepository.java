package com.mszostok.repository;

import com.mszostok.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;


/**
 * @author mszostok
 */
public interface PostRepository extends JpaRepository<Post, Integer>, JpaSpecificationExecutor {

    Page<Post> findByIsDeletedFalse(Pageable pageable);

    Optional<Post> findByIdPost(Integer id);
}
