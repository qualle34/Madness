package com.qualle.madness.github.client.config;

import lombok.*;

@Data
public class GitHubRestClientConfig {

    private String baseUrl;
    private String bestNumberUri;
    private String bestNumberPattern;
}
