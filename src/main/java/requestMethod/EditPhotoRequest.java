package requestMethod;

import base.ConfigRequest;

/**
 * Класс отвечает за создание правильного URL для запроса метода photos.editPhoto
 */
public class EditPhotoRequest {
    private String photo_id = "";
    private String gid = "";
    private String description = "";
    private static final String METHOD_NAME ="photos.editPhoto";

    public static Builder newBuilder() {
        return new EditPhotoRequest().new Builder();
    }

    public String createUrlWithParams() {
        return ConfigRequest.createBaseURL() +
                '&' + "photo_id" + '=' + photo_id +
                '&' + "gid" + '=' + gid +
                '&' + "description" + '=' + description +
                '&' + "method" + '=' + METHOD_NAME;
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public  Builder setPhotoId(String photo_id) {
            EditPhotoRequest.this.photo_id = photo_id;
            return this;
        }

        public Builder setGid(String gid) {
            EditPhotoRequest.this.gid = gid;
            return this;
        }

        public Builder setDescription(String description) {
            EditPhotoRequest.this.description = description;
            return this;
        }

        public EditPhotoRequest build() {
            return EditPhotoRequest.this;
        }
    }
}
