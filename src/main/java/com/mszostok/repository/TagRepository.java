package com.mszostok.repository;

import com.mszostok.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author mszostok
 */
public interface TagRepository extends JpaRepository<Tag, Integer>{

    Optional<Tag> findOneByTitle(String title);
}
