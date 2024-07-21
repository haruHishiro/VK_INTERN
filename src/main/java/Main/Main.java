package Main;

import base.ConfigRequest;
import base.GenerationData;
import base.HttpHelper;
import requestMethod.EditPhotoRequest;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        EditPhotoRequest photo = EditPhotoRequest.newBuilder()
                .setPhotoId("958298469296")
                .setDescription("test")
                .build();

        System.out.println(photo.createUrlWithParams());

        System.out.println(HttpHelper.getResponseBody(photo.createUrlWithParams()));
    }
}
