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
 * Тест проверяет изменение описания у групового фото не админом группы
 */
public class TestChangeDescriptionNotGroupAdmin {
    private static final String PHOTO_ID = "965142697737";
    private static final String GROUP_ID = "55309800374281";
    private static final String DESCRIPTION = GenerationData.getRandomString(5);
    private static final String ERROR = "REQUEST : Invalid request : errors.edit-group-photo.invalid.album.id";

    @Test
    void changeDescriptionGroupPhoto() throws IOException, InterruptedException {
        EditPhotoRequest editPhotoRequest = EditPhotoRequest.newBuilder()
                .setPhotoId(PHOTO_ID)
                .setGid(GROUP_ID)
                .setDescription(DESCRIPTION)
                .build();
        assertTrue(HttpHelper.getResponseBody(editPhotoRequest.createUrlWithParams()).contains(ERROR), "Пришла неверная ошибка");
    }
}
