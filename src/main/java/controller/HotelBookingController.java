package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import msa.commons.controller.airline.reservation.create.ReservationRequestDTO;
import services.airline.AirlineServices;
import services.hotel.HotelServices;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/booking")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HotelBookingController {
    private static final Logger LOGGER = LogManager.getLogger(HotelBookingController.class);
    private HotelServices hotelServices;
}
