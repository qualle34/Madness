package com.qualle.madness.github.client.retriever;

import com.qualle.madness.github.client.exception.GitHubRetrieverException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BestNumberRetriever {

    private final String pattern;

    public BestNumberRetriever(String pattern) {
        this.pattern = pattern;
    }

    public int retrieve(String s) {
        Matcher matcher = Pattern.compile(pattern).matcher(s);
        if (!matcher.find()) {
            throw new GitHubRetrieverException("No match found with pattern: " + pattern + " for string: " + s);
        }
        return Integer.parseInt(matcher.group(1));
    }
}
