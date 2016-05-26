package com.mszostok.model;

import com.mszostok.domain.User;
import com.mszostok.util.ParseUserRoles;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Current logged user object with proper username, password and authorities list.
 *
 * @author mszostok
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.geteMail(), user.getPassword(),
                AuthorityUtils.createAuthorityList(ParseUserRoles.toStringArray.apply(user.getRolesList())));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getIdUser().longValue();
    }

    public String[] getRole() {
        return ParseUserRoles.toStringArray.apply(user.getRolesList());
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                '}';
    }
}
