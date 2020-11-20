package com.qualle.madness.dto.exception;

public class ElementAssertionException extends RuntimeException {

    public ElementAssertionException(String message) {
        super(message);
    }

    public ElementAssertionException(String message, Throwable cause) {
        super(message, cause);
    }
}
