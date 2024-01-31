package com.linkedin.javacodechallenges;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            HttpRequest req = HttpRequest.newBuilder(new URI("https://icanhazdadjoke.com/"))
                    .header("Accept", "application/json")
                    .build();

            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(req, BodyHandlers.ofString());

            Gson gson = new Gson();
            Joke joke = gson.fromJson(response.body(), Joke.class);

            System.out.println(joke.getJoke());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
