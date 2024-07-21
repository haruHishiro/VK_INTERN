package requestMethod;

import base.ConfigRequest;

/**
 * Класс отвечает за создание правильного URL для запроса метода photos.getPhotoInfo
 */
public class GetPhotoInfoRequest {
    private String uid = "";
    private String photo_id = "";
    private String gid = "";
    private String fields = "";
    private static final String METHOD_NAME ="photos.getPhotoInfo";

    public static GetPhotoInfoRequest.Builder newBuilder() {
        return new GetPhotoInfoRequest().new Builder();
    }

    public String createUrlWithParams() {
        return ConfigRequest.createBaseURL() +
                '&' + "uid" + '=' + uid +
                '&' + "photo_id" + '=' + photo_id +
                '&' + "gid" + '=' + gid +
                '&' + "fields" + '=' + fields +
                '&' + "method" + '=' + METHOD_NAME;
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public Builder setUid(String userId) {
            GetPhotoInfoRequest.this.uid = userId;
            return this;
        }

        public Builder setPhotoId(String photo_id) {
            GetPhotoInfoRequest.this.photo_id = photo_id;
            return this;
        }

        public Builder setGid(String gid) {
            GetPhotoInfoRequest.this.gid = gid;
            return this;
        }

        public Builder setFields(String fields) {
            GetPhotoInfoRequest.this.fields = fields;
            return this;
        }

        public GetPhotoInfoRequest build() {
            return GetPhotoInfoRequest.this;
        }
    }
}