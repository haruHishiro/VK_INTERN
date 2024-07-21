package photoEdit.bad;

import base.HttpHelper;
import org.junit.jupiter.api.Test;
import requestMethod.EditPhotoRequest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест проверяет ошибку при отсутвии параметра photo_id
 */
public class TestChangeDescriptionWithoutPhotoId {
    private static final String ERROR = "PARAM : Missing required parameter photo_id\",\"error_data";

    @Test
    void changeDescriptionUserPhoto() throws IOException, InterruptedException {
        EditPhotoRequest editPhotoRequest = EditPhotoRequest.newBuilder().build();
        assertTrue(HttpHelper.getResponseBody(editPhotoRequest.createUrlWithParams()).contains(ERROR), "Пришла неверная ошибка");
    }
}
