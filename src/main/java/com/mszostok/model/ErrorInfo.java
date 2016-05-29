package com.mszostok.model;

/**
 * Error response model
 *
 * @author mszostok
 */
public class ErrorInfo {
    private final String url;
    private final String ex;

    public ErrorInfo(String url, Exception ex) {
        this.url = url;
        this.ex = ex.getLocalizedMessage();
    }
    public ErrorInfo(String url, String message) {
        this.url = url;
        this.ex = message;
    }

    public String getEx() {
        return ex;
    }

    public String getUrl() {
        return url;
    }
}
