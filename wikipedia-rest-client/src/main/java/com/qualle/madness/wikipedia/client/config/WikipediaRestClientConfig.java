package com.qualle.madness.wikipedia.client.config;

import lombok.Data;

@Data
public class WikipediaRestClientConfig {

    private String baseUrl;

    private String ytterbiumPageUri;
    private String astatinePageUri;
    private String holmiumPageUri;
    private String rheniumPageUri;
    private String germaniumPageUri;
    private String actiniumPageUri;
    private String goldPageUri;

    private String atomicNumberCssPath;
}
