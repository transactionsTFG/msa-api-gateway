package apiclient.hotel.booking;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import consts.api.MSAHotelPath;
import msa.commons.controller.hotel.booking.CreateHotelBookingDTO;

@Stateless
public class HotelBookingApiClientImpl implements HotelBookingApiClient {

    private static final String URL = MSAHotelPath.BOOKING.getFullPath() + "/booking";
    private final Client client = ClientBuilder.newClient();

    @Override
    public Response createBooking(CreateHotelBookingDTO dto) {
        return this.client.target(URL)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON));
    }

}
