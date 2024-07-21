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
 * Тест проверяет изменение описания у групового фото модератором группы
 */
public class TestChangeDescriptionGroupPhotoModerator {
    private static final String PHOTO_ID = "947310589501";
    private static final String GROUP_ID = "70000006754109";
    private static final String DESCRIPTION = GenerationData.getRandomString(5);

    @Test
    void changeDescriptionGroupPhotoModerator() throws IOException, InterruptedException {
        EditPhotoRequest editPhotoRequest = EditPhotoRequest.newBuilder()
                .setPhotoId(PHOTO_ID)
                .setGid(GROUP_ID)
                .setDescription(DESCRIPTION)
                .build();
        assertEquals("true", HttpHelper.getResponseBody(editPhotoRequest.createUrlWithParams()), "Ошибка запроса изменения фото");

        GetPhotoInfoRequest getPhotoInfoRequest = GetPhotoInfoRequest.newBuilder()
                .setPhotoId(PHOTO_ID)
                .setGid(GROUP_ID)
                .build();
        assertTrue(HttpHelper.getResponseBody(getPhotoInfoRequest.createUrlWithParams()).contains("\"text\":\""+DESCRIPTION + '"'), "Описание фото не изменилось");
    }
}
