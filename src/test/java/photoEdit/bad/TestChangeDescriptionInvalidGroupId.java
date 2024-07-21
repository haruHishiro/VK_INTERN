package photoEdit.bad;

import base.GenerationData;
import base.HttpHelper;
import org.junit.jupiter.api.Test;
import requestMethod.EditPhotoRequest;
import requestMethod.GetPhotoInfoRequest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест проверяет ошибку передачи невалидного параметра groupId
 */
public class TestChangeDescriptionInvalidGroupId {
    private static final String PHOTO_ID = "947310589501";
    private static final String GROUP_ID = GenerationData.getRandomString(5);
    private static final String ERROR = "PARAM : Param [" + GROUP_ID + "] conversion failed.";

    @Test
    void changeDescriptionInvalidGroupId() throws IOException, InterruptedException {
        EditPhotoRequest editPhotoRequest = EditPhotoRequest.newBuilder()
                .setPhotoId(PHOTO_ID)
                .setGid(GROUP_ID)
                .build();
        assertTrue(HttpHelper.getResponseBody(editPhotoRequest.createUrlWithParams()).contains(ERROR), "Пришла неверная ошибка");
    }
}
