package base;

import java.util.Locale;

public enum ConfigRequest {
    API_URL("https://api.ok.ru/fb.do?"),
    APPLICATION_KEY("CIOPKKLGDIHBABABA"),
    SESSION_KEY("-n-gwYvck2eUvdzF4mvCVb4qcBkmb2vyvmarXK9rrpXudlSKOQzAFrtuDBxlxqhaktcoWoE1nw2SmRcP9iJ91"),
    SIG("a10b40dd8418dd4d22eb2a4c085f09c0"),
    FORMAT("json");

    private final String value;

    ConfigRequest(String value) {
        this.value = value;
    }

    public static String createBaseURL() {
        return API_URL.value +
                APPLICATION_KEY.name().toLowerCase(Locale.ROOT) + '=' + APPLICATION_KEY.value +
                '&' + SESSION_KEY.name().toLowerCase(Locale.ROOT) + '=' + SESSION_KEY.value +
                '&' + SIG.name().toLowerCase(Locale.ROOT) + '=' + SIG.value +
                '&' + FORMAT.name().toLowerCase(Locale.ROOT) + '=' + FORMAT.value;
    }
}
