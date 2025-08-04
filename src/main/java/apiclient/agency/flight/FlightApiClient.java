package apiclient.agency.flight;

import javax.ws.rs.core.Response;

public interface FlightApiClient {
    Response getFlightById(long id);
    Response getFlightInstanceById(long id);
}
