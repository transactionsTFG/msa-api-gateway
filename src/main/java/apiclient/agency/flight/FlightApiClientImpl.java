package apiclient.agency.flight;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import consts.HttpsConsts;

@Stateless
public class FlightApiClientImpl implements FlightApiClient {
    private static final String PATH = HttpsConsts.URL_AGENCY  + "/msa-flight/api/flights";
    private Client client;
    @Override
    public Response getFlightById(long id) {
        return this.client.target(PATH + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get();
    }

    @Override
    public Response getFlightInstanceById(long id) {
        return this.client.target(PATH + "/instance/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get();
    }

    @Inject
    public void setClient(Client client) {
        this.client = client;
    }
    
}
