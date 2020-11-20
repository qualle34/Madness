package com.qualle.madness.wikipedia.client;

import com.qualle.madness.wikipedia.client.config.WikipediaRestClientConfig;
import com.qualle.madness.wikipedia.client.retriever.AtomicNumberRetriever;
import org.springframework.web.client.RestTemplate;

public class WikipediaRestClientImpl implements WikipediaRestClient {

    private final String URL_YTTERBIUM;
    private final String URL_ASTATINE;
    private final String URL_HOLMIUM;
    private final String URL_RHENIUM;
    private final String URL_GERMANIUM;
    private final String URL_ACTINIUM;
    private final String URL_GOLD;

    private final RestTemplate client;
    private final AtomicNumberRetriever retriever;

    public WikipediaRestClientImpl(RestTemplate client, WikipediaRestClientConfig config) {
        this.client = client;
        this.retriever = new AtomicNumberRetriever(config.getAtomicNumberCssPath());
        this.URL_YTTERBIUM = config.getBaseUrl() + config.getYtterbiumPageUri();
        this.URL_ASTATINE = config.getBaseUrl() + config.getAstatinePageUri();
        this.URL_HOLMIUM = config.getBaseUrl() + config.getHolmiumPageUri();
        this.URL_RHENIUM = config.getBaseUrl() + config.getRheniumPageUri();
        this.URL_GERMANIUM = config.getBaseUrl() + config.getGermaniumPageUri();
        this.URL_ACTINIUM = config.getBaseUrl() + config.getActiniumPageUri();
        this.URL_GOLD = config.getBaseUrl() + config.getGoldPageUri();
    }

    @Override
    public int getYtterbiumAtomicNumber() {
        String data = client.getForObject(URL_YTTERBIUM, String.class);
        return retriever.retrieve(data);
    }

    @Override
    public int getAstatineAtomicNumber() {
        String data = client.getForObject(URL_ASTATINE, String.class);
        return retriever.retrieve(data);
    }

    @Override
    public int getHolmiumAtomicNumber() {
        String data = client.getForObject(URL_HOLMIUM, String.class);
        return retriever.retrieve(data);
    }

    @Override
    public int getRheniumAtomicNumber() {
        String data = client.getForObject(URL_RHENIUM, String.class);
        return retriever.retrieve(data);
    }

    @Override
    public int getGermaniumAtomicNumber() {
        String data = client.getForObject(URL_GERMANIUM, String.class);
        return retriever.retrieve(data);
    }

    @Override
    public int getActiniumAtomicNumber() {
        String data = client.getForObject(URL_ACTINIUM, String.class);
        return retriever.retrieve(data);
    }

    @Override
    public int getGoldAtomicNumber() {
        String data = client.getForObject(URL_GOLD, String.class);
        return retriever.retrieve(data);
    }
}
