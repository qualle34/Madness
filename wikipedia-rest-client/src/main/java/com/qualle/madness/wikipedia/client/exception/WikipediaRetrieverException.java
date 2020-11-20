package com.qualle.madness.wikipedia.client.exception;

public class WikipediaRetrieverException extends RuntimeException {

    public WikipediaRetrieverException(String message) {
        super(message);
    }

    public WikipediaRetrieverException(String message, Throwable cause) {
        super(message, cause);
    }
}
