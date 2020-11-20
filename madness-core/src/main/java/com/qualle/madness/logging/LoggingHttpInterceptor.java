package com.qualle.madness.logging;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Slf4j
public class LoggingHttpInterceptor implements ClientHttpRequestInterceptor {

    private static final int MAX_BODY_SIZE = 1000;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        traceRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        traceResponse(response);
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException {
        log.info(">>> {} {}", request.getMethod(), request.getURI());
        log.info(">>> Headers = {}", request.getHeaders());
        log.info(">>> Body = {}", new String(body, StandardCharsets.UTF_8));
    }

    private void traceResponse(ClientHttpResponse response) throws IOException {
        String body = new BufferedReader(
                new InputStreamReader(response.getBody(), StandardCharsets.UTF_8))
                .lines().collect(Collectors.joining("\n"));

        log.info("<<< Status = {} {}", response.getStatusCode(), response.getStatusText());
        log.info("<<< Headers = {}", response.getHeaders());
        log.info("<<< Body = {}", body.substring(Math.min(body.length(), MAX_BODY_SIZE)));
    }
}