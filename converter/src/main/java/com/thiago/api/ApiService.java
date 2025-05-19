package main.java.com.thiago.api;

import com.google.gson.Gson;
import main.java.com.thiago.model.RateResponse;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.io.IOException;

public class ApiService {
    private static final String API_KEY = "c932f0df79ef30c8c6e89b8f";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    private final HttpClient client;
    private final Gson gson;

    public ApiService() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public String getRatesJson(String baseCurrency) throws IOException, InterruptedException {
        String url = BASE_URL + baseCurrency;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public RateResponse getRates(String baseCurrency) throws IOException, InterruptedException {
        String json = getRatesJson(baseCurrency);
        return gson.fromJson(json, RateResponse.class);
    }
}
