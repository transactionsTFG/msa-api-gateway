package business.travel;

import java.util.List;

import msa.commons.controller.airline.reservation.create.FlightInstanceSeatsDTO;

import lombok.Data;

@Data
public class UpdateReservationBookingDTO {
    private long bookingId;
    private String customerDNI;
    private String startDate;
    private String endDate;
    private int numberOfNights;
    private Boolean withBreakfast;
    private int peopleNumber;
    private List<Long> roomsInfo;
    private long idReservation;
    private long idTravel;
    private List<FlightInstanceSeatsDTO> flightInstanceSeats;
}
