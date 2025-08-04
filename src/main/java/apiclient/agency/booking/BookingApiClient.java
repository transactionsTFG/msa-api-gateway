package apiclient.agency.booking;

import javax.ws.rs.core.Response;

public interface BookingApiClient {
    Response getBookingById(long id);
}
