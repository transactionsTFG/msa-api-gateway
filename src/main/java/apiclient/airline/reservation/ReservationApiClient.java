package apiclient.airline.reservation;

import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import msa.commons.controller.airline.reservation.create.ReservationRequestDTO;

@Stateless
public interface ReservationApiClient {
    Response createReservation(ReservationRequestDTO dto);
}
