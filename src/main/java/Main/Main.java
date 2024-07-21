package Main;

import base.ConfigRequest;
import base.EditPhotoRequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(ConfigRequest.createBaseURL());
        EditPhotoRequest photo = EditPhotoRequest.newBuilder()
                .setPhotoId("958298469296")
                .setDescription("test")
                .build();

        System.out.println(photo.createUrlWithParams());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(photo.createUrlWithParams())).build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body().toString());
    }
}
