package com.mszostok.service;


import com.mszostok.domain.User;
import com.mszostok.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

/**
 * @author mszostok
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Collection<User> getAllActiveUsers() {
        return userRepository.findByActiveTrue();
    }

    @Override
    public Optional<User> getActiveUserByEmail(String email) {
        return userRepository.findOneByeMailAndActiveTrue(email);
    }

}
