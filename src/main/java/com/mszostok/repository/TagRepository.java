package com.mszostok.repository;

import com.mszostok.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mszostok
 */
public interface TagRepository extends JpaRepository<Tag, Integer>{
}
