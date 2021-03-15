package net.christophschubert.ccloud;


import java.io.IOException;

/**
 * Example class to demonstrate the features of the API client.
 */
public class Runner {

    public static final String API_KEY_ENV_VAR = "CCLOUD_APIKEY";
    public static final String API_SECRET_ENV_VAR = "CCLOUD_APISECRET";

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello Confluent Cloud");

        final var userName = System.getenv(API_KEY_ENV_VAR);
        final var password = System.getenv(API_SECRET_ENV_VAR);

        final CCloudApiClient client = new CCloudApiClient(userName, password);

        client.getEnvironments().forEach(System.out::println);
    }
}
