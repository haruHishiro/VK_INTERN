package photoEdit.bad;

import base.HttpHelper;
import org.junit.jupiter.api.Test;
import requestMethod.EditPhotoRequest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест проверяет изменение описания у пользовательского фото которое он не постил
 */
public class TestChangeDescriptionNotOwner {
    private static final String PHOTO_ID = "850649290020";
    private static final String ERROR = "REQUEST : Invalid request : error.edit.photo.notOwner";

    @Test
    void changeDescriptionNotOwner() throws IOException, InterruptedException {
        EditPhotoRequest editPhotoRequest = EditPhotoRequest.newBuilder()
                .setPhotoId(PHOTO_ID)
                .build();

        assertTrue(HttpHelper.getResponseBody(editPhotoRequest.createUrlWithParams()).contains(ERROR), "Пришла неверная ошибка");
    }
}
