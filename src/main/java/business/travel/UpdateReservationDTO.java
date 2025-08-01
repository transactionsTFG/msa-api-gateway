package business.travel;

import java.util.List;

import lombok.Data;
import msa.commons.controller.airline.reservation.create.FlightInstanceSeatsDTO;

@Data
public class UpdateReservationDTO {
    private long idReservation;
    private long idTravel;
    private List<FlightInstanceSeatsDTO> flightInstanceSeats;
}
