package apiclient.airline.reservation;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import consts.api.MSAirlinePath;
import msa.commons.controller.airline.reservation.create.ReservationRequestDTO;

@Stateless
public class ReservationApiClientImpl implements ReservationApiClient {
    private static final String URL = MSAirlinePath.RESERVATION.getFullPath() + "/reservation";
    private final Client client = ClientBuilder.newClient();

    @Override
    public Response createReservation(ReservationRequestDTO dto) {
        return this.client.target(URL)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON));
    }
    
}
