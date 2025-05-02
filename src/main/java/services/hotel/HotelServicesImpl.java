package services.hotel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import apiclient.hotel.booking.HotelBookingApiClient;
import msa.commons.controller.hotel.booking.CreateHotelBookingDTO;

@Stateless
public class HotelServicesImpl implements HotelServices {

    private HotelBookingApiClient hotelBookingApiClient;

    @Inject
    public void setHotelBookingApiClient(HotelBookingApiClient hotelBookingApiClient) {
        this.hotelBookingApiClient = hotelBookingApiClient;
    }

    @Override
    public boolean createBooking(CreateHotelBookingDTO dto) {
        try (Response response = this.hotelBookingApiClient.createBooking(dto)) {
            return response.getStatus() == Response.Status.CREATED.getStatusCode();
        }
    }

}
