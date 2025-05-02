package services.hotel;

import msa.commons.controller.hotel.booking.CreateHotelBookingDTO;

public interface HotelServices {
    boolean createBooking(CreateHotelBookingDTO dto);
}
