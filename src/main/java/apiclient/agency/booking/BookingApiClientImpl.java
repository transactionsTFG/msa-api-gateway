package apiclient.agency.booking;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import consts.HttpsConsts;

@Stateless
public class BookingApiClientImpl implements BookingApiClient {
    private static final String PATH = HttpsConsts.URL_AGENCY  + "/msa-hotel-booking/api/booking";
    private Client client;

    @Override
    public Response getBookingById(long id) {
        return this.client.target(PATH + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get();
    }
    
    @Inject
    public void setClient(Client client) {
        this.client = client;
    }

}
