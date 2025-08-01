package consts.api;

import consts.HttpsConsts;

public enum MSAirlinePath {
    RESERVATION("/msa-reservation-airline/api");

    private final String path;
    private MSAirlinePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getFullPath() {
        return HttpsConsts.URL_AIRLINE + path;
    }

}
