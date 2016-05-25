package com.mszostok.util;

import com.mszostok.domain.UserRole;

import java.util.List;
import java.util.function.Function;

/**
 * @author mszostok
 */
public class ParseUserRoles {

    public static Function<List<UserRole>,String[]> toStringArray
            = userRoles -> userRoles.stream().map(UserRole::getRole).toArray(String[]::new);


}
