package com.qualle.madness.service.impl;

import com.qualle.madness.dto.exception.ElementAssertionException;
import com.qualle.madness.github.client.GitHubRestClient;
import com.qualle.madness.service.ElementService;
import com.qualle.madness.wikipedia.client.WikipediaRestClient;

public class AstatineServiceImpl implements ElementService {

    private final GitHubRestClient gitHubClient;
    private final WikipediaRestClient wikipediaClient;

    public AstatineServiceImpl(GitHubRestClient gitHubClient, WikipediaRestClient wikipediaClient) {
        this.gitHubClient = gitHubClient;
        this.wikipediaClient = wikipediaClient;
    }

    @Override
    public int getAtomicNumber() {
        int githubNum = gitHubClient.getBestNumber();
        int wikipediaNum = wikipediaClient.getAstatineAtomicNumber();

        if (githubNum != wikipediaNum) {
            throw new ElementAssertionException("Assertion error, element from GitHub (" + githubNum + ") is not equal to an element from Wikipedia (" + wikipediaNum + ")");
        }

        return githubNum;
    }
}
