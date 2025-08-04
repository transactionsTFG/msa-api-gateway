package apiclient.agency.hotel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import consts.HttpsConsts;

@Stateless
public class RoomApiClientImpl implements RoomApiClient {
    private static final String PATH = HttpsConsts.URL_AGENCY  + "/msa-hotel-room/api/reservation";
    private Client client;

    @Override
    public Response getRoomById(long id) {
        return this.client.target(PATH + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get();
    }

    @Override
    public Response getRoomByCountryAndNameHotel(String country, String nameHotel) {
        return this.client.target(PATH + "/params")
                .queryParam("country", country)
                .queryParam("hotelName", nameHotel)
                .request(MediaType.APPLICATION_JSON)
                .get();
    }

    @Inject
    public void setClient(Client client) {
        this.client = client;
    }
}
