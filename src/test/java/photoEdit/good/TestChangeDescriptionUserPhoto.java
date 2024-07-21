package photoEdit.good;

import base.GenerationData;
import base.HttpHelper;
import org.junit.jupiter.api.Test;
import requestMethod.EditPhotoRequest;
import requestMethod.GetPhotoInfoRequest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест проверяет изменение описания у пользовательского фото
 */
public class TestChangeDescriptionUserPhoto {
    private static final String PHOTO_ID = "962884668600";
    private static final String DESCRIPTION = GenerationData.getRandomString(5);

    @Test
    void changeDescriptionUserPhoto() throws IOException, InterruptedException {
        EditPhotoRequest editPhotoRequest = EditPhotoRequest.newBuilder()
                .setPhotoId(PHOTO_ID)
                .setDescription(DESCRIPTION)
                .build();
        assertEquals("true", HttpHelper.getResponseBody(editPhotoRequest.createUrlWithParams()), "Ошибка запроса изменения фото");

        GetPhotoInfoRequest getPhotoInfoRequest = GetPhotoInfoRequest.newBuilder()
                .setPhotoId(PHOTO_ID)
                .build();
        assertTrue(HttpHelper.getResponseBody(getPhotoInfoRequest.createUrlWithParams()).contains("\"text\":\""+DESCRIPTION + '"'), "Описание фото не изменилось");
    }
}
