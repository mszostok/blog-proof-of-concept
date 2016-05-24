package com.mszostok.util;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Slug generator needed to create a short title given to an article,
 * the result can be use to create user friendly url.
 *
 * @author mszostok
 */
public class SlugGenerator {

    private static final Pattern NON_LATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    /**
     * Convert any string to pretty URL
     *
     * @param input string
     * @return readable url with maintaining input string sense
     */
    public static String toSlug(String input) {

        String noWhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(noWhitespace, Normalizer.Form.NFD);
        String slug = NON_LATIN.matcher(normalized).replaceAll("");

        return slug.toLowerCase(Locale.ENGLISH);
    }
}
