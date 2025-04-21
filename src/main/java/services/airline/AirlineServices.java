package services.airline;

import msa.commons.controller.airline.reservation.create.ReservationRequestDTO;

public interface AirlineServices {
    boolean createReservation(ReservationRequestDTO dto);
}
