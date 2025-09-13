package apiclient.agency.travel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.travel.TravelInfo;
import business.travel.UpdateHotelBookingDTO;
import business.travel.UpdateReservationBookingDTO;
import business.travel.UpdateReservationDTO;
import consts.HttpsConsts;
import msa.commons.controller.agency.reservationairline.ReservationAirlineRequestDTO;
import msa.commons.controller.agency.reservationbooking.CreateAirlineAndHotelReservationDTO;
import msa.commons.controller.hotel.booking.CreateHotelBookingDTO;

@Stateless
public class TravelApiClientImpl implements TravelApiClient {
    private static final String PATH = HttpsConsts.URL_AGENCY  + "/msa-travel/api/travel/reservation";
    private Client client;

    @Override
    public Response getTravelById(long id) {
        return this.client.target(PATH + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get();
    }

    @Override
    public Response getTravelByIdUser(long idUser) {
        return this.client.target(PATH + "/user/" + idUser)
                .request(MediaType.APPLICATION_JSON)
                .get();
    }

    @Override
    public Response getListTravel(TravelInfo dto) {
        return this.client.target(PATH + "/info")
                .queryParam("countryOrigin", dto.getCountryOrigin())
                .queryParam("countryDestination", dto.getCountryDestination())
                .queryParam("cityOrigin", dto.getCityOrigin())
                .queryParam("cityDestination", dto.getCityDestination())
                .queryParam("dateOrigin", dto.getDateOrigin())
                .queryParam("hotelName", dto.getHotelName())
                .request(MediaType.APPLICATION_JSON)
                .get();
    }

    @Override
    public Response getTravelByIdHotelAndIdFlight(long idHotel, long idFlight) {
        return this.client.target(PATH + "/hotel-airline/" + idHotel + "/" + idFlight)
                .request(MediaType.APPLICATION_JSON)
                .get();
    }

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

    @Inject
    public void setClient(Client client) {
        this.client = client;
    }
}
