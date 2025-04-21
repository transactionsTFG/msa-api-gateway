package services.airline;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import apiclient.airline.reservation.ReservationApiClient;
import msa.commons.controller.airline.reservation.create.ReservationRequestDTO;

@Stateless
public class AirlineServicesImpl implements AirlineServices {
    private ReservationApiClient reservationApiClient;

    @Override
    public boolean createReservation(ReservationRequestDTO dto) {
        try (Response response = this.reservationApiClient.createReservation(dto)) {
            return response.getStatus() == Response.Status.CREATED.getStatusCode(); 
        }
    }
    
    @Inject
    public void setReservationApiClient(ReservationApiClient reservationApiClient) {
        this.reservationApiClient = reservationApiClient;
    }
    
}