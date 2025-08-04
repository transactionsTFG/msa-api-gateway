package apiclient.agency.flight;

import javax.ws.rs.core.Response;

import business.flight.FlightParamsDTO;

public interface FlightApiClient {
    Response getFlightById(long id);
    Response getFlightInstanceById(long id);
    Response getFlightByParams(FlightParamsDTO params);
}
