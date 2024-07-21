package base;

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

        public  Builder setPhotoId(String userId) {
            EditPhotoRequest.this.photo_id = userId;
            return this;
        }

        public Builder setGid(String userId) {
            EditPhotoRequest.this.gid = userId;
            return this;
        }

        public Builder setDescription(String token) {
            EditPhotoRequest.this.description = token;
            return this;
        }

        public EditPhotoRequest build() {
            return EditPhotoRequest.this;
        }
    }
}
