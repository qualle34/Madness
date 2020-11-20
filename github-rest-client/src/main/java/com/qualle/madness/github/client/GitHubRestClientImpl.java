package com.qualle.madness.github.client;

import com.qualle.madness.github.client.config.GitHubRestClientConfig;
import com.qualle.madness.github.client.retriever.BestNumberRetriever;
import org.springframework.web.client.RestTemplate;

public class GitHubRestClientImpl implements GitHubRestClient {

    private final String URL_BEST_NUMBER;

    private final RestTemplate client;
    private final BestNumberRetriever retriever;

    public GitHubRestClientImpl(RestTemplate client, GitHubRestClientConfig config) {
        this.client = client;
        this.retriever = new BestNumberRetriever(config.getBestNumberPattern());
        URL_BEST_NUMBER = config.getBaseUrl() + config.getBestNumberUri();
    }

    @Override
    public int getBestNumber() {
        String data = client.getForObject(URL_BEST_NUMBER, String.class);
        return retriever.retrieve(data);
    }
}
