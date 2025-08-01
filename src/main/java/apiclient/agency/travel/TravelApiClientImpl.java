package apiclient.agency.travel;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.travel.UpdateHotelBookingDTO;
import business.travel.UpdateReservationBookingDTO;
import business.travel.UpdateReservationDTO;
import consts.HttpsConsts;
import msa.commons.controller.agency.reservationairline.ReservationAirlineRequestDTO;
import msa.commons.controller.agency.reservationbooking.CreateAirlineAndHotelReservationDTO;
import msa.commons.controller.hotel.booking.CreateHotelBookingDTO;

@Stateless
public class TravelApiClientImpl implements TravelApiClient {
    private static final String PATH = HttpsConsts.URL_AGENCY  + "/msa-travel/reservation";
    private final Client client = ClientBuilder.newClient();

    @Override
    public Response createReservation(ReservationAirlineRequestDTO dto) {
        return this.client.target(PATH + "/airline")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON));
    }

    @Override
    public Response createBooking(CreateHotelBookingDTO dto) {
        return this.client.target(PATH + "/hotel")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON));
    }

    @Override
    public Response createReservationAndBooking(CreateAirlineAndHotelReservationDTO dto) {
        return this.client.target(PATH + "/hotel-airline")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON));
    }

    @Override
    public Response updateReservation(UpdateReservationDTO dto) {
        return this.client.target(PATH + "/airline")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(dto, MediaType.APPLICATION_JSON));
    }

    @Override
    public Response updateBooking(UpdateHotelBookingDTO dto) {
        return this.client.target(PATH + "/hotel")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(dto, MediaType.APPLICATION_JSON));
    }

    @Override
    public Response updateReservationAndBooking(UpdateReservationBookingDTO dto) {
        return this.client.target(PATH + "/hotel-airline")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(dto, MediaType.APPLICATION_JSON));
    }

    @Override
    public Response deleteReservation(long id) {
        return this.client.target(PATH + "/airline/" + id)
                .request(MediaType.APPLICATION_JSON)
                .delete();
    }

    @Override
    public Response deleteBooking(long id) {
        return this.client.target(PATH + "/hotel/" + id)
                .request(MediaType.APPLICATION_JSON)
                .delete();
    }

    @Override
    public Response deleteReservationAndBooking(long idReservation, long idBooking) {
        return this.client.target(PATH + "/hotel-airline" + "/" + idReservation + "/" + idBooking)
                .request(MediaType.APPLICATION_JSON)
                .delete();
    }



}
