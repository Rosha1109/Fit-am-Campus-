package de.thk.gm.gdw.fitamcampus;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPClient {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newBuilder().build();
            String uniUri = "https://www.gm.th-koeln.de/~inf3127/";
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(uniUri))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
