package consts.api;

import consts.HttpsConsts;

public enum MSAHotelPath {
    BOOKING("/msa-hotel-booking/api");

    private final String path;

    private MSAHotelPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public String getFullPath() {
        return HttpsConsts.URL_HOTEL + this.path;
    }
}
