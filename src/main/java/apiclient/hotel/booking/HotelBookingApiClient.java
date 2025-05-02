package apiclient.hotel.booking;

import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import msa.commons.controller.hotel.booking.CreateHotelBookingDTO;

@Stateless
public interface HotelBookingApiClient {
    Response createBooking(CreateHotelBookingDTO dto);
}
