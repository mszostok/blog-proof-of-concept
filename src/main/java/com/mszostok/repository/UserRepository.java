package com.mszostok.repository;

import com.mszostok.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * @author mszostok
 */
public interface UserRepository extends JpaRepository<User, Integer>{

    Collection<User> findByActiveTrue();

}
