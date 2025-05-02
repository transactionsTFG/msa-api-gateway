package business;

import lombok.Data;
import msa.commons.controller.airline.reservation.create.ReservationRequestDTO;
import msa.commons.controller.hotel.booking.CreateHotelBookingDTO;

@Data
public class CreateAirlineAndHotelReservationDTO {
    private CreateHotelBookingDTO booking;
    private ReservationRequestDTO reservation;
}
