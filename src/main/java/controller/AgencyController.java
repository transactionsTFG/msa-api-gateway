package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import apiclient.agency.travel.TravelApiClient;
import business.travel.UpdateHotelBookingDTO;
import business.travel.UpdateReservationBookingDTO;
import business.travel.UpdateReservationDTO;
import msa.commons.controller.agency.reservationairline.ReservationAirlineRequestDTO;
import msa.commons.controller.agency.reservationbooking.CreateAirlineAndHotelReservationDTO;
import msa.commons.controller.hotel.booking.CreateHotelBookingDTO;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/agency")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgencyController {
    private static final Logger LOGGER = LogManager.getLogger(AgencyController.class);
    private TravelApiClient travelApiClient;

    @POST
    @Path("/create/airline")
    public Response createAirlineAndHotelReservation(ReservationAirlineRequestDTO dto) {
        LOGGER.info("Creating airline reservation: {}", dto);
        return travelApiClient.createReservation(dto);
    }

    @POST
    @Path("/create/hotel")
    public Response createHotelReservation(CreateHotelBookingDTO dto) {
        LOGGER.info("Creating hotel reservation: {}", dto);
        return travelApiClient.createBooking(dto);
    }

    @POST
    @Path("/create/hotel-airline")
    public Response createAirlineAndHotelReservation(CreateAirlineAndHotelReservationDTO dto) {
        LOGGER.info("Creating airline and hotel reservation: {}", dto);
        return travelApiClient.createReservationAndBooking(dto);
    }

    @PUT
    @Path("/update/airline")
    public Response updateAirlineReservation(UpdateReservationDTO dto) {
        LOGGER.info("Updating airline reservation: {}", dto);
        return travelApiClient.updateReservation(dto);
    }

    @PUT
    @Path("/update/hotel")
    public Response updateHotelBooking(UpdateHotelBookingDTO dto) {
        LOGGER.info("Updating hotel booking: {}", dto);
        return travelApiClient.updateBooking(dto);
    }

    @PUT
    @Path("/update/hotel-airline")
    public Response updateAirlineAndHotelReservation(UpdateReservationBookingDTO dto) {
        LOGGER.info("Updating airline and hotel reservation: {}", dto);
        return travelApiClient.updateReservationAndBooking(dto);
    }

    @DELETE
    @Path("/delete/airline")
    public Response deleteAirlineReservation(long reservationId) {
        LOGGER.info("Deleting airline reservation with ID: {}", reservationId);
        return travelApiClient.deleteReservation(reservationId);
    }

    @DELETE
    @Path("/delete/hotel")
    public Response deleteHotelBooking(long bookingId) {
        LOGGER.info("Deleting hotel booking with ID: {}", bookingId);
        return travelApiClient.deleteBooking(bookingId);
    }

    @DELETE
    @Path("/delete/hotel-airline")
    public Response deleteAirlineAndHotelReservation(long reservationId, long bookingId) {
        LOGGER.info("Deleting airline reservation with ID: {} and hotel booking with ID: {}", reservationId, bookingId);
        return travelApiClient.deleteReservationAndBooking(reservationId, bookingId);
    }

    @EJB
    public void setTravelApiClient(TravelApiClient travelApiClient) {
        this.travelApiClient = travelApiClient;
    }
}
