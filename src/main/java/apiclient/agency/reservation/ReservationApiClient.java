package apiclient.agency.reservation;

import javax.ws.rs.core.Response;

public interface ReservationApiClient {
    Response getReservationById(long id);
}
