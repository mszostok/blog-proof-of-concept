package com.mszostok.service;


import com.mszostok.domain.User;
import com.mszostok.model.CurrentUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author mszostok
 */
@Service("userDetailsService")
public class CurrentUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LogManager.getLogger(CurrentUserDetailsService.class);

    @Autowired
    UserService userService;
    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        LOGGER.info("Authenticating user with email = {}", email);
        User user = userService.getActiveUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
        return new CurrentUser(user);
    }
}
