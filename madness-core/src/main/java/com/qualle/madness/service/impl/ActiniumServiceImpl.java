package com.qualle.madness.service.impl;

import com.qualle.madness.service.ElementService;
import com.qualle.madness.wikipedia.client.WikipediaRestClient;

public class ActiniumServiceImpl implements ElementService {

    private final WikipediaRestClient wikipediaClient;

    public ActiniumServiceImpl(WikipediaRestClient wikipediaClient) {
        this.wikipediaClient = wikipediaClient;
    }

    @Override
    public int getAtomicNumber() {
        return wikipediaClient.getActiniumAtomicNumber();
    }
}
