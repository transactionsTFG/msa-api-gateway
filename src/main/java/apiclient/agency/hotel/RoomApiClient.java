package apiclient.agency.hotel;

import javax.ws.rs.core.Response;

public interface RoomApiClient {
    Response getRoomById(long id);
    Response getRoomByCountryAndNameHotel(String country, String nameHotel);
}
