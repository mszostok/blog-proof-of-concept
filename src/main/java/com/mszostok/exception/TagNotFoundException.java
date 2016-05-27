package com.mszostok.exception;

/**
 * @author mszostok
 */
public class TagNotFoundException extends  RuntimeException {

    public TagNotFoundException(String tag) {
        super("No posts found for tag #" + tag);
    }
}
