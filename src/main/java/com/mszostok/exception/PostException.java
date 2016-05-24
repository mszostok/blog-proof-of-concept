package com.mszostok.exception;

/**
 * Exception use when post(s) cannot be found.
 *
 * @author mszostok
 */
public class PostException extends  RuntimeException {

    public PostException(String message) {
        super("Post exception. " + message);
    }
}
