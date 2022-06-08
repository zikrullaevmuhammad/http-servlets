package com.mzik.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

import static java.net.http.HttpRequest.BodyPublishers.*;
import static java.net.http.HttpResponse.BodyHandlers.ofString;

public class HttpClientExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .GET()
                .build();

        HttpRequest request2 = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .POST(ofFile(Path.of("path", "to", "file")))
                .build();
        var response = httpClient.send(request, ofString());
        System.out.println(response.body());
        System.out.println(response.headers());
    }
}
