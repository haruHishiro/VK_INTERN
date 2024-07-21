package photoEdit.bad;

import base.GenerationData;
import base.HttpHelper;
import org.junit.jupiter.api.Test;
import requestMethod.EditPhotoRequest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест проверяет ошибку при передачи невалидной сессии
 */
public class TestChangeDescriptionInvalidSessionKey {
    private static final String INVALID_SESSION_KEY = GenerationData.getRandomString(5);
    private static final String ERROR = "PARAM_SESSION_KEY : Invalid session key";

    @Test
    void changeDescriptionInvalidSessionKey() throws IOException, InterruptedException {
        EditPhotoRequest editPhotoRequest = EditPhotoRequest.newBuilder().build();
        assertTrue(HttpHelper.getResponseBody(editPhotoRequest.createUrlWithInvalidSessionKeyParam(INVALID_SESSION_KEY)).contains(ERROR), "Пришла неверная ошибка");
    }
}
