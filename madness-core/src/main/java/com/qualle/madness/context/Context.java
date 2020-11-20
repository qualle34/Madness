package com.qualle.madness.context;

import com.qualle.madness.config.Configuration;
import com.qualle.madness.github.client.GitHubRestClient;
import com.qualle.madness.github.client.GitHubRestClientImpl;
import com.qualle.madness.logging.LoggingHttpInterceptor;
import com.qualle.madness.service.ElementService;
import com.qualle.madness.service.impl.*;
import com.qualle.madness.wikipedia.client.WikipediaRestClient;
import com.qualle.madness.wikipedia.client.WikipediaRestClientImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Context {

    private final Configuration config;

    private ElementService actiniumServiceImpl;
    private ElementService astatineServiceImpl;
    private ElementService germaniumServiceImpl;
    private ElementService goldServiceImpl;
    private ElementService osmiumServiceImpl;
    private ElementService rheniumServiceImpl;
    private ElementService ytterbiumServiceImpl;

    private GitHubRestClient gitHubRestClient;
    private WikipediaRestClient wikipediaRestClient;

    public Context(Configuration config) {
        this.config = config;
    }

    public ElementService actiniumServiceImpl() {
        if (actiniumServiceImpl == null) {
            actiniumServiceImpl = new ActiniumServiceImpl(wikipediaRestClient());
            log.info("ActiniumService was created");
        }
        return actiniumServiceImpl;
    }

    public ElementService astatineServiceImpl() {
        if (astatineServiceImpl == null) {
            astatineServiceImpl = new AstatineServiceImpl(gitHubRestClient(), wikipediaRestClient());
            log.info("AstatineService was created");
        }
        return astatineServiceImpl;
    }

    public ElementService germaniumServiceImpl() {
        if (germaniumServiceImpl == null) {
            germaniumServiceImpl = new GermaniumServiceImpl(wikipediaRestClient());
            log.info("GermaniumService was created");
        }
        return germaniumServiceImpl;
    }

    public ElementService goldServiceImpl() {
        if (goldServiceImpl == null) {
            goldServiceImpl = new GoldServiceImpl(wikipediaRestClient());
            log.info("GoldService was created");
        }
        return goldServiceImpl;
    }

    public ElementService osmiumServiceImpl() {
        if (osmiumServiceImpl == null) {
            osmiumServiceImpl = new HolmiumServiceImpl(wikipediaRestClient());
            log.info("OsmiumService was created");
        }
        return osmiumServiceImpl;
    }

    public ElementService rheniumServiceImpl() {
        if (rheniumServiceImpl == null) {
            rheniumServiceImpl = new RheniumServiceImpl(wikipediaRestClient());
            log.info("RheniumService was created");
        }
        return rheniumServiceImpl;
    }

    public ElementService ytterbiumServiceImpl() {
        if (ytterbiumServiceImpl == null) {
            ytterbiumServiceImpl = new YtterbiumServiceImpl(wikipediaRestClient());
            log.info("YtterbiumService was created");
        }
        return ytterbiumServiceImpl;
    }

    private GitHubRestClient gitHubRestClient() {
        if (gitHubRestClient == null) {
            gitHubRestClient = new GitHubRestClientImpl(restTemplate(), config.getGitHubRestClientConfig());
            log.info("GitHubRestClient was created");
        }
        return gitHubRestClient;
    }

    public WikipediaRestClient wikipediaRestClient() {
        if (wikipediaRestClient == null) {
            wikipediaRestClient = new WikipediaRestClientImpl(restTemplate(), config.getWikipediaRestClientConfig());
            log.info("WikipediaRestClient was created");
        }
        return wikipediaRestClient;
    }

    private RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new LoggingHttpInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}
