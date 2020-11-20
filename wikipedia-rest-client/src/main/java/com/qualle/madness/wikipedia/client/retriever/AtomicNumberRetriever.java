package com.qualle.madness.wikipedia.client.retriever;

import com.qualle.madness.wikipedia.client.exception.WikipediaRetrieverException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class AtomicNumberRetriever {

    private final String cssPath;

    public AtomicNumberRetriever(String cssPath) {
        this.cssPath = cssPath;
    }

    public int retrieve(String html) {
        try {
            Document doc = Jsoup.parse(html);
            Element value = doc.selectFirst(cssPath);
            return Integer.parseInt(value.text());
        } catch (Exception e) {
            throw new WikipediaRetrieverException("Unable to retrieve atomic number from by pattern: " + cssPath, e);
        }
    }
}
