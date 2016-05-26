package com.mszostok.exception;

/**
 * Exception for any post error.
 *
 * @author mszostok
 */
public class PostException extends  RuntimeException {

    public PostException(String message) {
        super("Post exception. " + message);
    }
}
