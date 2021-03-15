package net.christophschubert.ccloud;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.christophschubert.ccloud.model.Environment;
import net.christophschubert.ccloud.model.Response;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

public class CCloudApiClient {

    public static final String DEFAULT_V2_BASE_URL = "https://api.confluent.cloud/v2";

    private final String authHeader;
    private final String baseUrl;
    private final HttpClient httpClient = HttpClient.newBuilder().build();
    static final ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public CCloudApiClient(String username, String password) {
        this(username, password, DEFAULT_V2_BASE_URL);
    }

    public CCloudApiClient(String username, String password, String baseUrl) {
        this.authHeader = basicAuth(username, password);
        this.baseUrl = baseUrl;
    }

    HttpRequest buildRequest(String method, String endpoint) {
        return HttpRequest.newBuilder(URI.create(baseUrl + endpoint))
                .method(method, HttpRequest.BodyPublishers.noBody())
                .header("Authorization", authHeader)
                .build();
    }

    public List<Environment> getEnvironments() {
        final HttpRequest request = buildRequest("GET", "/environments");

        try {
            final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            final Response response1 = mapper.readValue(response.body(), Response.class);
            return response1.data;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


    private static String basicAuth(String username, String password) {
        return "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
    }
}
