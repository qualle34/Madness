package com.qualle.madness.config;

import com.qualle.madness.github.client.config.GitHubRestClientConfig;
import com.qualle.madness.wikipedia.client.config.WikipediaRestClientConfig;
import lombok.*;

@Data
public class Configuration {

    private GitHubRestClientConfig gitHubRestClientConfig;

    private WikipediaRestClientConfig wikipediaRestClientConfig;

    private HttpClient httpClient;

    @Data
    public static final class HttpClient {
        private int connectTimeout;
        private int connectionRequestTimeout;
        private int socketTimeout;
        private int connectionMax;
        private int maxPerRoute;
    }
}
