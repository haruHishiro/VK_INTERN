package photoEdit.bad;

import base.GenerationData;
import base.HttpHelper;
import org.junit.jupiter.api.Test;
import requestMethod.EditPhotoRequest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест проверяет ошибку передачи невалидного параметра photoId
 */
public class TestChangeDescriptionInvalidPhotoId {
    private static final String PHOTO_ID = GenerationData.getRandomString(5);
    private static final String ERROR = "PARAM_USER_ID : Invalid uid [" + PHOTO_ID + "]";

    @Test
    void changeDescriptionInvalidPhotoId() throws IOException, InterruptedException {
        EditPhotoRequest editPhotoRequest = EditPhotoRequest.newBuilder()
                .setPhotoId(PHOTO_ID)
                .build();
        assertTrue(HttpHelper.getResponseBody(editPhotoRequest.createUrlWithParams()).contains(ERROR), "Пришла неверная ошибка");
    }
}
