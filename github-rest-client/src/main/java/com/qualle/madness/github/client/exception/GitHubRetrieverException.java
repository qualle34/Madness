package com.qualle.madness.github.client.exception;

public class GitHubRetrieverException extends RuntimeException {

    public GitHubRetrieverException(String message) {
        super(message);
    }

    public GitHubRetrieverException(String message, Throwable cause) {
        super(message, cause);
    }
}
