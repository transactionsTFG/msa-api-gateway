package apiclient.agency.reservation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import consts.HttpsConsts;

@Stateless
public class ReservationApiClientImpl implements ReservationApiClient {
    private static final String PATH = HttpsConsts.URL_AGENCY  + "/msa-reservation-airline/api/reservation";
    private Client client;
    
    @Override
    public Response getReservationById(long id) {
        return this.client.target(PATH + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get();
    }
    

    @Inject
    public void setClient(Client client) {
        this.client = client;
    }

}
