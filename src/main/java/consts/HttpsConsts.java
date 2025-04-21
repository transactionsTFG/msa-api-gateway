package consts;

public class HttpsConsts {
    private HttpsConsts() {}
    private static final String HTTPS = "https://";
    private static final String DOMAIN = "localhost";
    private static final String PORT_HOTEL = "7002";
    private static final String PORT_AIRLINE = "8002";
    private static final String PORT_AGENCY = "9002";
    public static final String URL_HOTEL = HTTPS + DOMAIN + ":" + PORT_HOTEL;
    public static final String URL_AIRLINE = HTTPS + DOMAIN + ":" + PORT_AIRLINE;
    public static final String URL_AGENCY = HTTPS + DOMAIN + ":" + PORT_AGENCY;
}
