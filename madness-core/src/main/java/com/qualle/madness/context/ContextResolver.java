package com.qualle.madness.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.qualle.madness.config.Configuration;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class ContextResolver {

    private final static String LOCAL_CONFIG_FILE_NAME = "config.yaml";

    private static Context context;

    public static Context getInstance() {
        if (context == null) {
            synchronized (ContextResolver.class) {
                if (context == null) {
                    context = createContext();
                    log.info("New context was created");
                }
            }
        }
        return context;
    }

    private static Context createContext() {
        Configuration config = loadConfig();
        return new Context(config);
    }

    private static Configuration loadConfig() {

        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            return mapper.readValue(ContextResolver.class.getResourceAsStream("/" + LOCAL_CONFIG_FILE_NAME), Configuration.class);

        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to load application configs", e);
        }
    }
}
